package com.example.user.fuckinggreatadvicegetter;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import io.realm.Realm;


public class AdviceFragment extends Fragment {

    private String advice;
    private TextView textView;
    Realm realm;
    private Handler handler = new Handler();

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
        getButton.setOnClickListener(v -> {
            GetAdvice getAdvice = new GetAdvice();
            getAdvice.execute();
            try {
                advice = getAdvice.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            textView.setText(advice);
        });
        saveButton.setOnClickListener(v -> {
            realm = Realm.getDefaultInstance();
            DBController dbController = new DBController();
            dbController.add(advice);
        });
        return view;
    }

    private class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            GetAdvice getAdvice = new GetAdvice();
            getAdvice.execute();
            try {
                advice = getAdvice.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            handler.post(() -> textView.setText(advice));
        }
    }
}