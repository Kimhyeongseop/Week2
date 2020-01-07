package com.example.senthil.kotlin_tablayout.Fragment

import android.content.Intent
import android.content.Intent.getIntent
import android.content.Intent.parseIntent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.senthil.kotlin_tablayout.*
import com.example.senthil.kotlin_tablayout.R

import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_tab3.view.*

class Tab3Fragment : Fragment() {

    private var ListViewItemList = ArrayList<Tab3CoinListViewItem>()
    private lateinit var priceRef : DatabaseReference
    private var email: String? = null


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


        val intent=activity!!.intent
        email=intent?.getStringExtra("email")

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
        val fab_my_page: View = view.findViewById(R.id.FAB)
        fab_my_page.setOnClickListener {
            val intent = Intent(context, Who::class.java)
            intent.putExtra("email",email)
            startActivity(intent)
        }

        // Inflate the layout for this fragment
        return view
    }
}
