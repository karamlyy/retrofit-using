package com.karamlyy.retrofittask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class Adapter(private val heros: List<HerosDTO>) : RecyclerView.Adapter<Adapter.HeroViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.single_item, parent, false)
        return HeroViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = heros[position]
        holder.bind(hero)
    }

    override fun getItemCount(): Int {
        return heros.size
    }

    inner class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.nameHero)
        private val realname: TextView = itemView.findViewById(R.id.realNameHero)
        private val team: TextView = itemView.findViewById(R.id.teamHero)
        private val firstappearance: TextView = itemView.findViewById(R.id.firstappearanceHero)
        private val createdby: TextView = itemView.findViewById(R.id.createdbyHero)
        private val publisher : TextView = itemView.findViewById(R.id.publisherHero)
        private val bio : TextView = itemView.findViewById(R.id.bioHero)
        private val image : ImageView = itemView.findViewById(R.id.imgHero)

        fun bind(heros: HerosDTO) {
            name.text = heros.name
            realname.text = heros.realname
            team.text = heros.team
            firstappearance.text = heros.firstappearance
            createdby.text = heros.createdby
            publisher.text = heros.publisher
            bio.text = heros.bio
            //Picasso.get().load("${heros.imageurl}").into(image)
        }
    }
}