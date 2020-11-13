package com.dwifauzi.uts18090125

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_row_berita.view.*

class ListBeritaAdapter(private val listBerita: ArrayList<Berita>) : RecyclerView.Adapter<ListBeritaAdapter.ListViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_berita, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listBerita[position])
    }

    override fun getItemCount(): Int = listBerita.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(berita: Berita){
            with(itemView){
                Glide.with(itemView.context)
                    .load(berita.photo)
                    .apply(RequestOptions().override(55, 55))
                    .into(img_item_photo)

                tv_item_name.text = berita.name
                tv_item_description.text = berita.description

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