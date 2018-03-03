package com.example.user.fuckinggreatadvicegetter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class AdviceFragment extends Fragment {

    private String url = "http://fucking-great-advice.ru/api/";
    private TextView textView;
    private String advice;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    Realm realm;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.advice_fragment, container, false);

        setRetainInstance(true);
        if (savedInstanceState == null) {
            TimerTask timerTask = new MyTimerTask();
            Timer timer = new Timer(true);
            timer.scheduleAtFixedRate(timerTask, 0, 30 * 1000);
        }
        textView = view.findViewById(R.id.text);
        Button getButton = view.findViewById(R.id.getbutton);
        Button saveButton = view.findViewById(R.id.savebutton);

        getButton.setOnClickListener(v -> getAdvice());
        saveButton.setOnClickListener(v -> {
            realm = Realm.getDefaultInstance();
            DBController dbController = new DBController();
            dbController.add(advice);
            AdviceAdapter adapter = ((MainActivity) getActivity()).getAdapter();
            adapter.onItemAdd();
        });
        return view;
    }

    private class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            getAdvice();
        }
    }

    private void getAdvice() {
        FGAClient fgaClient = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(FGAClient.class);

        compositeDisposable.add(fgaClient.getData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError));
    }

    private void handleResponse(Advice adv) {
        advice = adv.getText();
        textView.setText(adv.getText());
    }

    private void handleError(Throwable error) {
        Toast.makeText(getContext(), "Error " + error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}