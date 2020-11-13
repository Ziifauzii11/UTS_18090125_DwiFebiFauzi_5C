package com.dwifauzi.uts18090125

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_cardview_berita.view.*

class CardViewBeritaAdapter(private val listBerita: ArrayList<Berita>) : RecyclerView.Adapter<CardViewBeritaAdapter.CardViewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_berita, parent, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bind(listBerita[position])
    }

    override fun getItemCount(): Int = listBerita.size

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(berita: Berita){
            with(itemView){
                Glide.with(itemView.context)
                    .load(berita.photo)
                    .apply(RequestOptions().override(350, 550))
                    .into(img_item_photo)

                tv_item_name.text = berita.name
                tv_item_description.text = berita.description

                btn_set_favorite.setOnClickListener{
                    Toast.makeText(itemView.context, "Favorite ${berita.name}", Toast.LENGTH_SHORT).show()
                }

                btn_set_share.setOnClickListener{
                    Toast.makeText(itemView.context, "Share ${berita.name}", Toast.LENGTH_SHORT).show()
                }

                itemView.setOnClickListener{
                    Toast.makeText(itemView.context, "Kamu memilih ${berita.name}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}