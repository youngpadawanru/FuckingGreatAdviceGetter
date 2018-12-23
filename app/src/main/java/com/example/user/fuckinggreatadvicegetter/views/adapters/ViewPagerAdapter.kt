package com.example.user.fuckinggreatadvicegetter.views.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class ViewPagerAdapter(
        fragmentManager: FragmentManager, private val fragmentTitleList: Array<String>, private val fragmentList: Array<Fragment>
) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(p0: Int): Fragment {
        return fragmentList[p0]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitleList[position]
    }
}