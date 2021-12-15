package com.taufik.androidpemula

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.taufik.androidpemula.databinding.ItemHeroBinding

class HeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<HeroAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroAdapter.ViewHolder {
        val view = ItemHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroAdapter.ViewHolder, position: Int) {
        holder.bind(listHero[position])
    }

    override fun getItemCount(): Int = listHero.size

    inner class ViewHolder(private val binding: ItemHeroBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(hero: Hero) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(hero.photo)
                    .apply(RequestOptions().override(55,55))
                    .into(imgItemPhoto)

                tvHeroName.text = hero.name
                tvHeroDesc.text = hero.detail
            }
        }
    }
}