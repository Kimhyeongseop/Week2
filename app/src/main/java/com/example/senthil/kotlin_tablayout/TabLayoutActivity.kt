package com.example.senthil.kotlin_tablayout

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.senthil.kotlin_tablayout.Fragment.GalleryFragment
import com.example.senthil.kotlin_tablayout.Fragment.Tab3Fragment
import com.example.senthil.kotlin_tablayout.Fragment.PhoneFragment
import com.facebook.stetho.Stetho
import kotlinx.android.synthetic.main.activity_tab_layout.*

class TabLayoutActivity : AppCompatActivity() {

    // to get permissions
    private val multiplePermissionsCode = 100
    //List of Permissions
    private val requiredPermssions = arrayOf(
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Stetho.initializeWithDefaults(this)
        var rejectedPermissionList = ArrayList<String>()

        //check !
        while (ContextCompat.checkSelfPermission(this, requiredPermssions[0]) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, requiredPermssions[1]) != PackageManager.PERMISSION_GRANTED)
        {
            for (permission in requiredPermssions)
            {
                if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED)
                    rejectedPermissionList.add(permission)
            }

            //if user rejected permission...
            if (rejectedPermissionList.isNotEmpty())
            {
                //try again!
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
