package com.example.senthil.kotlin_tablayout.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.senthil.kotlin_tablayout.CustomAdapter
import com.example.senthil.kotlin_tablayout.R
import com.example.senthil.kotlin_tablayout.User
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_phone.*
import kotlinx.android.synthetic.main.fragment_phone.view.*

class PhoneFragment : Fragment() {

    private var phoneList = ArrayList<User>()

    private lateinit var database: DatabaseReference


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_phone, container, false)
        val manager = LinearLayoutManager(this.context)

        view.mRecyclerView.layoutManager = manager
        val adapter = CustomAdapter(phoneList, context!!)

        //database = FirebaseDatabase.getInstance().getReference("User")
        database = FirebaseDatabase.getInstance().getReference("User")

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(shot: DataSnapshot)
            {
                phoneList.clear()
                for (snapshot in shot.getChildren()) {

                   var user = snapshot.getValue(User::class.java)

                    phoneList.add(user!!)
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(p0: DatabaseError) {
                Log.e("TAG",  "@@@@ ERROR while get data from the database")
            }
        })

        view.mRecyclerView.adapter = adapter

        return view
    }
}
