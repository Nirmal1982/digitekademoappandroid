package com.example.digitekademoappapplirossel.compose

import android.annotation.SuppressLint
import android.util.Xml
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import com.google.accompanist.web.AccompanistWebViewClient
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewStateWithHTMLData
import kotlin.math.absoluteValue

const val MIMETYPE = "text/html; charset=UTF-8"

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun ArticleWebView(webViewClient: AccompanistWebViewClient, bodyHTML: String, webviewPositionScript: String) {
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
                    val positionScript = "display_webview_position(${layoutCoordinates.positionInWindow().y})"
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
