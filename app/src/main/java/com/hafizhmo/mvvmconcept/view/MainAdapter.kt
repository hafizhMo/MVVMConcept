package com.hafizhmo.mvvmconcept.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hafizhmo.mvvmconcept.R
import com.hafizhmo.mvvmconcept.databinding.ItemMainBinding
import com.hafizhmo.mvvmconcept.model.CharacterResponseItem

class MainAdapter(
    val context: Context, private val characters: List<CharacterResponseItem>
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemMainBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: CharacterResponseItem) {
            with(binding) {
                nameText.text = character.name
                Glide.with(context)
                    .load(character.image)
                    .apply(
                        RequestOptions()
                            .placeholder(R.drawable.loading_animation)
                            .error(R.drawable.ic_broken_image)
                    )
                    .into(characterImage)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemMainBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount(): Int = characters.size
}