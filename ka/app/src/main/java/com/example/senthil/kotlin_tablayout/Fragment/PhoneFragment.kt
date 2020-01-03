package com.example.senthil.kotlin_tablayout.Fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.senthil.kotlin_tablayout.CustomAdapter
import com.example.senthil.kotlin_tablayout.R
import com.example.senthil.kotlin_tablayout.User
import com.example.senthil.kotlin_tablayout.sub
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_phone.view.*

class PhoneFragment : Fragment() {

    private var phoneList = ArrayList<User>()

    private lateinit var database: DatabaseReference

    var button: Button? = null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_phone, container, false)
        val manager = LinearLayoutManager(this.context)

        view.mRecyclerView.layoutManager = manager
        val adapter = CustomAdapter(phoneList, context!!)
        val REQUEST_CODE = 3


        button = view.findViewById<View>(R.id.btn) as Button
        button!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity!!.applicationContext, sub::class.java)
            startActivityForResult(intent,REQUEST_CODE)
        })

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
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
       super.onActivityResult(requestCode, resultCode, data)

        val adapter = CustomAdapter(phoneList, context!!)
        val REQUEST_CODE = 3

        if (requestCode ==REQUEST_CODE) {
            val str1 = data!!.getStringExtra("fn")
            val str3 = data!!.getStringExtra("pn")
            if (str1 != null) {
                val newuser = User(str1, str3)
                database.child(str1).setValue(newuser)
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
                view!!.mRecyclerView.adapter = adapter

            } else {
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

                view!!.mRecyclerView.adapter = adapter

            }
        }
    }
}
