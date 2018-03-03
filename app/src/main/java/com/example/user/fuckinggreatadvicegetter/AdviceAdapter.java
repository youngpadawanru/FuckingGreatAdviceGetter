package com.example.user.fuckinggreatadvicegetter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;


class AdviceAdapter extends RecyclerView.Adapter<AdviceAdapter.ViewHolder> implements ItemTouchHelperAdapter {

    private final RealmResults<Advice> advices;

    AdviceAdapter(RealmResults<Advice> obj) {
        advices = obj;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.advice_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.advice_text.setText(advices.get(i).getText());
    }

    @Override
    public int getItemCount() {
        return advices.size();
    }

    @Override
    public void onItemDismiss(int position) {
        notifyItemRemoved(position);
    }

    public void onItemAdd() {
        int position = getItemCount() + 1;
        notifyItemInserted(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.advice_text)
        TextView advice_text;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}