package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.data.File
import com.example.myapplication.databinding.ItemFileviewBinding

class FileAdapter(private val list: ArrayList<File>) : RecyclerView.Adapter<FileAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemFileviewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFileviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var file = list[position]
        holder.binding.txtTitle.setText(file.title)
        holder.binding.txtDescription.setText(file.description)
        Glide.with(holder.itemView.context).load(file.thumbnailUrl)
            .fitCenter()
            .into(holder.binding.imgFileIcon)
//        holder.binding.eventView.setOnClickListener{
//            var intent = Intent(holder.binding.eventView.context,EventDetailActivity::class.java)
//            var bundle = Bundle()
//            bundle.putSerializable("event",event);
//            intent.putExtras(bundle)
//            holder.binding.eventView.context.startActivity(intent)
//        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}