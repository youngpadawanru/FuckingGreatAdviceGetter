package com.example.user.fuckinggreatadvicegetter.views.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.user.fuckinggreatadvicegetter.R
import com.example.user.fuckinggreatadvicegetter.model.Advice
import io.realm.RealmResults

class FavoritesListAdapter(private val advices: RealmResults<Advice>) : RecyclerView.Adapter<FavoritesListAdapter.ViewHolder>() {
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.adviceText.text = advices[p1]?.text
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.advice_item, p0, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return advices.size
    }

    fun onItemAdd() {
        notifyItemInserted(itemCount + 1)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var adviceText: TextView = itemView.findViewById(R.id.advice_text)
    }
}

