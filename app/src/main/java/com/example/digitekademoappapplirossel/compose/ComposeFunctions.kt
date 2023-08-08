package com.example.digitekademoappapplirossel.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.google.accompanist.web.AccompanistWebViewClient

@Composable
fun DisplayWebViewBody(
    webViewClient: AccompanistWebViewClient,
    body: String = ""
) {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        ArticleWebView(webViewClient, body)
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
