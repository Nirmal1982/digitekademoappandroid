package com.example.digitekademoappapplirossel.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.digitekademoappapplirossel.R
import com.example.digitekademoappapplirossel.adapters.ArticlePagerAdapter
import com.example.digitekademoappapplirossel.assets.bodyHTML

class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)
        val articleList = listOf(bodyHTML, bodyHTML, bodyHTML)

        viewPager.adapter = ArticlePagerAdapter(articleList)
    }
}

