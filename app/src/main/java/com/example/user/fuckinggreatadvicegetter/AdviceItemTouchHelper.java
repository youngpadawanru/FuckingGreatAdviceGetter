package com.example.user.fuckinggreatadvicegetter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import io.realm.Realm;
import io.realm.RealmResults;


class AdviceItemTouchHelper extends ItemTouchHelper.Callback {

    private final ItemTouchHelperAdapter adapter;
    private Realm realm;
    private RealmResults<Advice> advices;


    public AdviceItemTouchHelper(ItemTouchHelperAdapter InAdapter) {
        adapter = InAdapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = 0;
        int swipeFlags = ItemTouchHelper.START;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        realm = Realm.getDefaultInstance();
        DBController dbController = new DBController();
        advices = realm.where(Advice.class).findAll();
        Advice advice = advices.get(viewHolder.getAdapterPosition());
        dbController.remove(advice.getId());
        adapter.onItemDismiss(viewHolder.getAdapterPosition());
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return false;
    }
}