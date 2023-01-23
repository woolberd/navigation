package com.example.navigation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.navigation.`interface`.OnClickItem
import com.example.navigation.databinding.ItemNameBinding
import com.example.navigation.model.HomeModel

class LanguageAdapter(
    private val listText: ArrayList<HomeModel>,
    private val onClickItem: OnClickItem
) : RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>(), View.OnLongClickListener {

    inner class LanguageViewHolder(private val binding: ItemNameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: HomeModel) {
            binding.txtName.text = model.name
            Glide.with(binding.imageCat.context).load(model.image).into(binding.imageCat)
            itemView.setOnClickListener {
                onClickItem.onClick(model)
                binding.txtName.text = model.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        return LanguageViewHolder(
            ItemNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.itemView.setOnLongClickListener(this)
        holder.onBind(listText[position])
        holder.itemView.setOnLongClickListener {
            listText.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
            true
        }
    }

    override fun getItemCount(): Int {
        return listText.size
    }

    override fun onLongClick(v: View?): Boolean {
        onClickItem.onLongClick(v?.tag as HomeModel)
        return true
    }
}