package com.example.user.fuckinggreatadvicegetter.helper

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import com.example.user.fuckinggreatadvicegetter.presenters.FavoritesPresenter

class ListItemTouchHelper(private val favoritesPresenter: FavoritesPresenter) : ItemTouchHelper.Callback() {

    override fun getMovementFlags(p0: RecyclerView, p1: RecyclerView.ViewHolder): Int {
        val dragFlags = 0
        val swipeFlags = ItemTouchHelper.START
        return ItemTouchHelper.Callback.makeMovementFlags(dragFlags, swipeFlags)
    }

    override fun onMove(p0: RecyclerView, p1: RecyclerView.ViewHolder, p2: RecyclerView.ViewHolder): Boolean {
        return false
    }

    override fun onSwiped(p0: RecyclerView.ViewHolder, p1: Int) {
        favoritesPresenter.onItemDismiss(p0.adapterPosition)
    }
}