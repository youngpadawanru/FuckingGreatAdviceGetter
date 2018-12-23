package com.example.user.fuckinggreatadvicegetter.views

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.example.user.fuckinggreatadvicegetter.R
import com.example.user.fuckinggreatadvicegetter.views.adapters.FavoritesListAdapter
import com.example.user.fuckinggreatadvicegetter.views.adapters.ViewPagerAdapter
import io.realm.Realm

class MainActivity : AppCompatActivity() {

    private var adapter: FavoritesListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Realm.init(this)
        val viewPager = findViewById<ViewPager>(R.id.mainActivityPager)
        val tabLayout = findViewById<TabLayout>(R.id.tablayout)
        setupViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val fragments = arrayOf(AdviceFragment(), FavoritesFragment())
        val titles = arrayOf(resources.getString(R.string.advice), resources.getString(R.string.favorites))
        val adapter = ViewPagerAdapter(supportFragmentManager, titles, fragments)
        viewPager.adapter = adapter
    }

    fun setAdapter(adapter: FavoritesListAdapter) {
        this.adapter = adapter
    }

    fun getAdapter(): FavoritesListAdapter? {
        return adapter
    }
}