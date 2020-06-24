package com.tonynowater.librarytest.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tonynowater.librarytest.R
import kotlinx.android.synthetic.main.item_demo.view.tv_item


typealias OnClickListener = (position: Int) -> Unit

class MenuAdapter(private val data: ArrayList<String>) : RecyclerView.Adapter<MyViewHolder>() {

    var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_demo,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.count()

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.tv_item.text = data[position]
        holder.itemView.setOnClickListener {
            onClickListener?.invoke(position)
        }
    }
}

class MyAdapter(private val data: Array<Int?>) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_demo,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.count()

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.tv_item.text = "$position."
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
