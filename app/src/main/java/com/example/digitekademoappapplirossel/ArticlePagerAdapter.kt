package com.example.digitekademoappapplirossel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.compose.ui.platform.ComposeView
import androidx.recyclerview.widget.RecyclerView
import com.google.accompanist.web.AccompanistWebViewClient

class ArticlePagerAdapter(private val articles: List<String>) : RecyclerView.Adapter<ArticleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val itemView = inflater.inflate(R.layout.viewpager_item, parent, false)
        val webViewClient = getWebViewClient()

        return ArticleViewHolder(itemView, webViewClient)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val articleBody = articles[position]
        holder.bind(articleBody)
    }

    override fun getItemCount(): Int = articles.size
}

class ArticleViewHolder(itemView: View, private val webViewClient: AccompanistWebViewClient) : RecyclerView.ViewHolder(itemView) {
    private val composeView = itemView.findViewById<ComposeView>(R.id.composeView)

    fun bind(bodyHTML: String) {
        composeView.setContent {
            DisplayWebViewBody(webViewClient, bodyHTML)
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


