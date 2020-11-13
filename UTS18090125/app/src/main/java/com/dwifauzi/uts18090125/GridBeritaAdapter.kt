package com.dwifauzi.uts18090125

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_grid_berita.view.*

class GridBeritaAdapter(private val listBerita: ArrayList<Berita>) : RecyclerView.Adapter<GridBeritaAdapter.GridViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_berita, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.bind(listBerita[position])
    }

    override fun getItemCount(): Int = listBerita.size

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(berita: Berita){
            with(itemView){
                Glide.with(itemView.context)
                    .load(berita.photo)
                    .apply(RequestOptions().override(350, 550))
                    .into(img_item_photo)

                itemView.setOnClickListener{
                    onItemClickCallback?.onItemClicked(berita)
                }
            }
        }
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: Berita)
    }
}