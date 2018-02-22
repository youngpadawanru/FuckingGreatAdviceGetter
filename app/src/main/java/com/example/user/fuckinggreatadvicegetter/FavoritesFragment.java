package com.example.user.fuckinggreatadvicegetter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

import static android.support.v7.widget.RecyclerView.VERTICAL;


public class FavoritesFragment extends Fragment {

    Realm realm;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    AdviceAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    DividerItemDecoration dividerItemDecoration;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.favorites_fragment, container, false);
        ButterKnife.bind(this, view);
        layoutManager = new LinearLayoutManager(getContext());
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), VERTICAL);
        adapter = new AdviceAdapter(realm.where(Advice.class).findAll());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);
        ItemTouchHelper.Callback callback = new AdviceItemTouchHelper(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);
        ((MainActivity) getActivity()).setAdapter(adapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        realm = Realm.getDefaultInstance();
        recyclerView = new RecyclerView(getActivity());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
