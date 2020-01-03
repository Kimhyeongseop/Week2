package com.example.senthil.kotlin_tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
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
        adapter.addFragment(PhoneFragment(),"Phone")
        adapter.addFragment(GalleryFragment(), "Gallery")
        adapter.addFragment(Tab3Fragment(), "(Tab3)")
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
