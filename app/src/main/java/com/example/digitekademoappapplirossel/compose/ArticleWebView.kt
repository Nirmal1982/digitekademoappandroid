package com.example.digitekademoappapplirossel.compose

import android.annotation.SuppressLint
import android.content.Context
import android.util.Xml
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.core.widget.NestedScrollView
import com.example.digitekademoappapplirossel.R
import com.example.digitekademoappapplirossel.utils.DeviceScreenUtils.getPxFromDp
import com.google.accompanist.web.AccompanistWebViewClient
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewStateWithHTMLData

const val MIMETYPE = "text/html; charset=UTF-8"

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun ArticleWebView(webViewClient: AccompanistWebViewClient, bodyHTML: String, webviewPositionScript: String, context: Context, fragmentView: View) {
    var headerHeight = 0f
    val saveWebView = remember { mutableStateOf<WebView?>(null) }
    val webClient = remember { webViewClient }
    val state = rememberWebViewStateWithHTMLData(
        data = bodyHTML,
        encoding = Xml.Encoding.UTF_8.name,
        mimeType = MIMETYPE,
        historyUrl = null
    )

    WebView(
        modifier = Modifier.onGloballyPositioned { layoutCoordinates ->
            saveWebView.let { state ->
                state.value?.let {
                    // Detect the nestedScrollView's height in px
                    val nestedScrollView: NestedScrollView = fragmentView.findViewById(R.id.articleDetailNestedScrollView)
                    val nestedScrollViewHeight = getPxFromDp(context, nestedScrollView.height.toFloat())

                    // Detect the height of the header in px (same as initial position of the webview)
                    if (headerHeight == 0f) headerHeight = layoutCoordinates.positionInWindow().y

                    val positionScript = "display_webview_position(${layoutCoordinates.positionInWindow().y}, $headerHeight, $nestedScrollViewHeight)"
                    val fullScript = "$webviewPositionScript\n$positionScript"
                    it.evaluateJavascript(fullScript) { }
                }
            }
        },
        state = state,
        onCreated = {
            saveWebView.value = it
            it.apply {
                settings.domStorageEnabled = true
                settings.setNeedInitialFocus(false)
                settings.loadsImagesAutomatically = true
                settings.javaScriptEnabled = true
                settings.cacheMode = WebSettings.LOAD_NO_CACHE

                isVerticalScrollBarEnabled = false
                isHorizontalScrollBarEnabled = false
                isScrollContainer = true
                isHapticFeedbackEnabled = false
            }
        },
        client = webClient
    )
}
