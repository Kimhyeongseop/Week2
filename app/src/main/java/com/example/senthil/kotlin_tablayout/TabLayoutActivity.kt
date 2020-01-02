package com.example.senthil.kotlin_tablayout

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import com.example.senthil.kotlin_tablayout.Fragment.GalleryFragment
import com.example.senthil.kotlin_tablayout.Fragment.AccountBookFragment
import com.example.senthil.kotlin_tablayout.Fragment.AddressFragment
import kotlinx.android.synthetic.main.activity_tab_layout.*
import android.support.v4.app.SupportActivity
import android.support.v4.app.SupportActivity.ExtraData
import android.support.v4.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.facebook.stetho.Stetho


class TabLayoutActivity : AppCompatActivity()
{
    private val multiplePermissionsCode = 100

    //List of Permissions
    private val requiredPermissions = arrayOf(
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.READ_EXTERNAL_STORAGE )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Stetho.initializeWithDefaults(this)
        var rejectedPermissionList = ArrayList<String>()

        //필요한 퍼미션들을 하나씩 끄집어내서 현재 권한을 받았는지 체크
        while (ContextCompat.checkSelfPermission(this, requiredPermissions[0])!= PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, requiredPermissions[1])!= PackageManager.PERMISSION_GRANTED) {
            for (permission in requiredPermissions) {
                if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                    //만약 권한이 없다면 rejectedPermissionList에 추가
                    rejectedPermissionList.add(permission)
                }
            }
            //거절된 퍼미션이 있다면...
            if (rejectedPermissionList.isNotEmpty()) {
                //권한 요청!
                val array = arrayOfNulls<String>(rejectedPermissionList.size)
                ActivityCompat.requestPermissions(this, rejectedPermissionList.toArray(array), multiplePermissionsCode)
            }
        }

        setContentView(R.layout.activity_tab_layout)

        setupViewPager(viewpager)

        tabs!!.setupWithViewPager(viewpager)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(AddressFragment(),"Account")
        adapter.addFragment(GalleryFragment(), "Gallery")
        adapter.addFragment(AccountBookFragment(), "Account Book")
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
