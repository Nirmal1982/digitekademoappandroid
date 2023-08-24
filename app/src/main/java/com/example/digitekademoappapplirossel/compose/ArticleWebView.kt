package com.example.digitekademoappapplirossel.compose

import android.annotation.SuppressLint
import android.content.Context
import android.util.TypedValue
import android.util.Xml
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.LinearLayout
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
                    //TODO Statusbar's height in px -> calculate it instead
                    val statusBarHeight = getPxFromDp(context, 24f)

                    // Calculates the tool bar's height in px
                    var toolBarHeight = 0
                    val tv = TypedValue()
                    if (context.theme.resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
                        toolBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, context.resources.displayMetrics)
                    }

                    var initialPosition = -1 * (statusBarHeight + toolBarHeight) // Position before the header is rendered on screen

                    // Header's height in px
                    val headerHeight: Int = fragmentView.findViewById<LinearLayout?>(R.id.breadcrumbContainer).height

                    // NestedScrollView's height in px
                    val nestedScrollViewHeight: Int = fragmentView.findViewById<NestedScrollView?>(R.id.articleDetailNestedScrollView).height

                    // Calculate webview's current position in px
                    val currentPosition = layoutCoordinates.positionInWindow().y.toInt() - statusBarHeight - toolBarHeight - 45 // Margin of error seems to be 45px

                    // Detect the webview's initial position in px
                    if (initialPosition == -1 * (statusBarHeight + toolBarHeight)) initialPosition = currentPosition

                    val positionScript = "display_webview_position($statusBarHeight, $toolBarHeight, $headerHeight, $nestedScrollViewHeight, $initialPosition, $currentPosition)"
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
