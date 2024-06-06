package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.data.File
import com.example.myapplication.databinding.ItemFileviewBinding
import com.example.myapplication.util.OnItemClickListener

class FileAdapter(private val list: ArrayList<File>, private val listener: OnItemClickListener<File>, private val buttonCLickListener: OnItemClickListener<File>) : RecyclerView.Adapter<FileAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemFileviewBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position, list[position])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFileviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val file = list[position]
        holder.binding.txtTitle.text = file.title
        holder.binding.txtDescription.text = file.description
        Glide.with(holder.itemView.context).load(file.thumbnailUrl)
            .fitCenter()
            .into(holder.binding.imgFileIcon)
        holder.binding.btnFileDownload.setOnClickListener(View.OnClickListener {
            buttonCLickListener.onItemClick(position, file)
        })
    }

    override fun getItemCount(): Int {
        return list.size
    }
}