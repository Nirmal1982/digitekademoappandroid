package com.example.digitekademoappapplirossel.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.digitekademoappapplirossel.interfaces.WebviewPositionCallback
import com.google.accompanist.web.AccompanistWebViewClient

@Composable
fun DisplayWebViewBody(
    webViewClient: AccompanistWebViewClient,
    body: String = "",
    positionCallback: WebviewPositionCallback
) {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        ArticleWebView(webViewClient, body, positionCallback)
        HandlePaywall()
    }
}

@Composable
fun HandlePaywall() {
    Text(
        text = "Paywall",
        style = TextStyle(fontSize = 18.sp)
    )
}
