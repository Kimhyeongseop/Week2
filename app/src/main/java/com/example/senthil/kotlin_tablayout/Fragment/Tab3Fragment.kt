package com.example.senthil.kotlin_tablayout.Fragment

<<<<<<< HEAD
import android.content.Intent
import android.os.Bundle
import android.util.Log
=======
import android.os.Bundle
>>>>>>> 9de0792135b121a1c2c2128c1776232156b5243c
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
<<<<<<< HEAD
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.senthil.kotlin_tablayout.*
import com.example.senthil.kotlin_tablayout.R

import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_tab3.*
import kotlinx.android.synthetic.main.fragment_tab3.view.*

class Tab3Fragment : Fragment() {

    private var ListViewItemList = ArrayList<Tab3CoinListViewItem>()
    private lateinit var priceRef : DatabaseReference

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        /* JAVA style...
        val listView : ListView
        val view = inflater.inflate(R.layout.fragment_tab3, container, false) as ListView
        listView = view.findViewById(R.id.coin_list)
        */
        val view = inflater.inflate(R.layout.fragment_tab3, container, false)
        val manager = LinearLayoutManager(this.context)
        val adapter = Tab3Adapter(ListViewItemList, context!!)
        view.coin_list.adapter = adapter
        view.coin_list.layoutManager = manager

        priceRef = FirebaseDatabase.getInstance().getReference("Prices")

        priceRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(shot: DataSnapshot) {
                ListViewItemList.clear()
                for (snapshot in shot.children) //e.g) snapshot == BTC
                {
                    var image = snapshot.child("icon").value.toString()
                    var price = snapshot.child("price").value.toString() + "￦"
                    var addMe = Tab3CoinListViewItem(image, snapshot.key.toString(), price)

                    //Log.d("@@@@@@@@", image + " | " + snapshot.key + " | " + price)

                    ListViewItemList.add(addMe)
                }
                adapter.notifyDataSetChanged()
            }
            override fun onCancelled(p0: DatabaseError) {
                Log.e("#### TAG ####: ", " ERROR in 'Tab3Adapter'")
            }
        })

        //for FAB : go_to_my_page
        val fab_my_page: View = view.findViewById(R.id.FAB_go_to_my_page)
        fab_my_page.setOnClickListener {
            val intent = Intent(context, Tab3MyPage::class.java)
            startActivity(intent)
        }




        // Inflate the layout for this fragment
        return view
=======

import com.example.senthil.kotlin_tablayout.R

class Tab3Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab3, container, false)
>>>>>>> 9de0792135b121a1c2c2128c1776232156b5243c
    }
}
