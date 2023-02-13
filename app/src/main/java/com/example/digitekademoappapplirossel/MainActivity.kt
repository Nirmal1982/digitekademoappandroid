package com.example.digitekademoappapplirossel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class MainActivity : AppCompatActivity() {
    private lateinit var webview: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webview = findViewById(R.id.idDtkWebView)
        webview.apply {
            settings.javaScriptEnabled = true
            isScrollContainer=true
            loadUrl("https://mockup.digiteka.com/mockup_rossel_android.html")
        }
    }
}
