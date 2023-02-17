package com.example.digitekademoappapplirossel.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.digitekademoappapplirossel.R
import com.example.digitekademoappapplirossel.models.SecondArticle


class SecondArticleAdapter(val context: Context): RecyclerView.Adapter<ViewHolder>() {
    private val items = listOf(
        SecondArticle(title = context.getString(R.string.item_second_articles_title)),
        SecondArticle(title = context.getString(R.string.item_second_articles_title)),
        SecondArticle(title = context.getString(R.string.item_second_articles_title)))
    init {
        notifyItemRangeInserted(0,3)
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return SecondArticleViewHolder(view = LayoutInflater.from(context).inflate(R.layout.item_second_article, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder as SecondArticleViewHolder
        holder.bind(model = items[position])
    }

    private class SecondArticleViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(model: SecondArticle) {
            view.findViewById<TextView>(R.id.second_article_title).text = model.title
        }
    }
}