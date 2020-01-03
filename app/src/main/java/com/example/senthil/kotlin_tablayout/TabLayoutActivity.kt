package com.example.senthil.kotlin_tablayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import com.example.senthil.kotlin_tablayout.Fragment.GalleryFragment
import com.example.senthil.kotlin_tablayout.Fragment.Tab3Fragment
import com.example.senthil.kotlin_tablayout.Fragment.PhoneFragment
import kotlinx.android.synthetic.main.activity_tab_layout.*

class TabLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)

        setupViewPager(viewpager)

        tabs!!.setupWithViewPager(viewpager)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(PhoneFragment(),"Home")
        adapter.addFragment(GalleryFragment(), "About Us")
        adapter.addFragment(Tab3Fragment(), "Contact Us")
        viewPager.adapter = adapter
    }

    internal inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mFragmentTitleList[position]
        }
    }
}
