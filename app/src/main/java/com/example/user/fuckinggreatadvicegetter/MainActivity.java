package com.example.user.fuckinggreatadvicegetter;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.realm.Realm;


public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    AdviceAdapter adapter;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm.init(this);
        viewPager = (ViewPager) findViewById(R.id.mainActivityPager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AdviceFragment(), getResources().getString(R.string.advice));
        adapter.addFragment(new FavoritesFragment(), getResources().getString(R.string.favorites));
        viewPager.setAdapter(adapter);
    }

    public void setAdapter(AdviceAdapter adapter) {
        this.adapter = adapter;
    }

    public AdviceAdapter getAdapter() {
        return adapter;
    }
}