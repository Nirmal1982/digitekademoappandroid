package com.example.digitekademoappapplirossel.compose

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
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
import org.json.JSONObject

const val MIMETYPE = "text/html; charset=UTF-8"

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun ArticleWebView(webViewClient: AccompanistWebViewClient, bodyHTML: String, webviewPositionScript: String, context: Context, fragmentView: View) {
    var initialWebViewPosition = -1
    var marginOfErrorOfPosition = 0

    //variables added by Digiteka
    var isPlayerLaunched = false;
    var isScriptInProcess = false;
    var closeSticky = false;

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

                    // Header's height in px
                    val headerHeight: Int = fragmentView.findViewById<LinearLayout?>(R.id.breadcrumbContainer).height

                    // NestedScrollView's height in px
                    val nestedScrollViewHeight: Int = fragmentView.findViewById<NestedScrollView?>(R.id.articleDetailNestedScrollView).height

                    // Calculate webview's current position in px
                    val currentPosition = layoutCoordinates.positionInWindow().y.toInt() - statusBarHeight - toolBarHeight

                    // Detect the webview's initial position in px and calculate margin of error
                    if (initialWebViewPosition < 0) {
                        initialWebViewPosition = currentPosition
                        marginOfErrorOfPosition = initialWebViewPosition - headerHeight
                    }
                    //val positionScript = "display_webview_position($statusBarHeight, $toolBarHeight, $headerHeight, $nestedScrollViewHeight, ${initialWebViewPosition - marginOfErrorOfPosition}, ${currentPosition - marginOfErrorOfPosition})"

                    //Modified code by DIGITEKA
                    if(!isScriptInProcess && !closeSticky){
                        isScriptInProcess = true;
                        val density = Resources.getSystem().getDisplayMetrics().density
                        var newCurrentPosition = currentPosition / density
                        var newInitialWebViewPosition = initialWebViewPosition / density
                        var newNestedScrollViewHeight = nestedScrollViewHeight / density
                        val positionScript = "display_webview_position($statusBarHeight, $toolBarHeight, $headerHeight, $newNestedScrollViewHeight, ${newInitialWebViewPosition}, ${newCurrentPosition},  ${isPlayerLaunched}, ${closeSticky})"
                        val fullScript = "$webviewPositionScript\n$positionScript"
                        it.evaluateJavascript(fullScript) { value ->
                            val jsonObject = JSONObject(value)
                            isPlayerLaunched = jsonObject.getBoolean("isPlayerLaunched")
                            closeSticky = jsonObject.getBoolean("closeSticky")
                            isScriptInProcess = false;
                        }
                    }
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
