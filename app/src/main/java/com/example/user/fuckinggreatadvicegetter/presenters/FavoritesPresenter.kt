package com.example.user.fuckinggreatadvicegetter.presenters

import com.example.user.fuckinggreatadvicegetter.views.adapters.FavoritesListAdapter
import com.example.user.fuckinggreatadvicegetter.model.Advice
import com.example.user.fuckinggreatadvicegetter.model.database.DBController
import io.realm.RealmResults

class FavoritesPresenter : ItemTouchHelperAdapter {
    private val dbController = DBController()
    val adapter = FavoritesListAdapter(getAdviceList())

    override fun onItemDismiss(position: Int) {
        dbController.remove(getAdviceList()[position]!!.id)
        adapter.notifyItemRemoved(position)
    }

    private fun getAdviceList(): RealmResults<Advice> {
        return dbController.findAll()!!
    }
}

interface ItemTouchHelperAdapter {

    fun onItemDismiss(position: Int)
}