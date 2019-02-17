package com.example.user.fuckinggreatadvicegetter.views

import android.os.Bundle
import android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener
import android.support.v7.app.AppCompatActivity
import com.example.user.fuckinggreatadvicegetter.R
import com.example.user.fuckinggreatadvicegetter.views.adapters.FavoritesListAdapter
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var adapter: FavoritesListAdapter? = null
    private val adviceFragment = AdviceFragment()
    private val favoritesFragment = FavoritesFragment()
    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Realm.init(this)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        fragmentManager.beginTransaction().add(R.id.frame_container, adviceFragment).commit()
    }

    fun setAdapter(adapter: FavoritesListAdapter) {
        this.adapter = adapter
    }

    fun getAdapter(): FavoritesListAdapter? {
        return adapter
    }

    private val mOnNavigationItemSelectedListener = OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.adviceFragment -> {
                fragmentManager.beginTransaction().replace(R.id.frame_container, adviceFragment).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.favoritesFragment -> {
                fragmentManager.beginTransaction().replace(R.id.frame_container, favoritesFragment).commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}