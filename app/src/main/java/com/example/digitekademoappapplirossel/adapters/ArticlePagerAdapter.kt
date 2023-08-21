package com.example.digitekademoappapplirossel.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.compose.ui.platform.ComposeView
import androidx.recyclerview.widget.RecyclerView
import com.example.digitekademoappapplirossel.R
import com.example.digitekademoappapplirossel.compose.DisplayWebViewBody
import com.google.accompanist.web.AccompanistWebViewClient

class ArticlePagerAdapter(private val articles: List<String>, private val fragmentView: View) : RecyclerView.Adapter<ArticleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val itemView = inflater.inflate(R.layout.viewpager_item, parent, false)
        val webViewClient = getWebViewClient()

        return ArticleViewHolder(itemView, webViewClient, context, fragmentView)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val articleBody = articles[position]
        holder.bind(articleBody)
    }

    override fun getItemCount(): Int = articles.size
}

class ArticleViewHolder(itemView: View, private val webViewClient: AccompanistWebViewClient, private val context: Context, private val fragmentView: View) : RecyclerView.ViewHolder(itemView) {
    private val composeView = itemView.findViewById<ComposeView>(R.id.composeView)

    fun bind(bodyHTML: String) {
        val webviewPositionScript = loadWebviewPositionScript(context) // Load the JavaScript code from asset
        composeView.setContent {
            DisplayWebViewBody(webViewClient, bodyHTML, webviewPositionScript, context, fragmentView)
        }
    }

    private fun loadWebviewPositionScript(context: Context): String {
        try {
            val assetManager = context.assets
            val inputStream = assetManager.open("webview_position.js")
            return inputStream.bufferedReader().use { it.readText() }
        } catch (e: Exception) {
            Log.e("AssetManager", "Error loading webview_position.js: ${e.message}")
            return ""
        }
    }

}

private fun getWebViewClient() : AccompanistWebViewClient {
    return object : AccompanistWebViewClient() {
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
        }
    }
}


