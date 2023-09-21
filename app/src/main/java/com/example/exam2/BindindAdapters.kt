package com.example.exam2

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exam2.model.Crypto

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<Crypto>?) {
    val adapter = recyclerView.adapter as CryptoAdapter
    adapter.submitList(data)
}