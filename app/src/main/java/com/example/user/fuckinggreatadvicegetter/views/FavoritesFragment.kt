package com.example.user.fuckinggreatadvicegetter.views

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.VERTICAL
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.user.fuckinggreatadvicegetter.R
import com.example.user.fuckinggreatadvicegetter.helper.ListItemTouchHelper
import com.example.user.fuckinggreatadvicegetter.presenters.FavoritesPresenter

class FavoritesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.favorites_fragment, container, false)
        retainInstance = true
        val favoritesPresenter = FavoritesPresenter()
        val recyclerView: RecyclerView
        val layoutManager = LinearLayoutManager(context)
        val adapter = favoritesPresenter.adapter
        val callback = ListItemTouchHelper(favoritesPresenter)
        val touchHelper = ItemTouchHelper(callback)
        recyclerView = view.findViewById(R.id.recycler_view)
        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, VERTICAL)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(dividerItemDecoration)
        touchHelper.attachToRecyclerView(recyclerView)
        (activity as MainActivity).setAdapter(adapter)
        return view
    }
}