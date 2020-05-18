package com.example.senthil.kotlin_tablayout.Fragment

<<<<<<< HEAD
import android.content.Intent
import android.os.Bundle
=======
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
>>>>>>> 9de0792135b121a1c2c2128c1776232156b5243c
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
<<<<<<< HEAD
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.senthil.kotlin_tablayout.*
import com.example.senthil.kotlin_tablayout.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.*
=======
import androidx.recyclerview.widget.RecyclerView
import com.example.senthil.kotlin_tablayout.CustomAdapter
import com.example.senthil.kotlin_tablayout.R
import com.example.senthil.kotlin_tablayout.User
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_phone.*
>>>>>>> 9de0792135b121a1c2c2128c1776232156b5243c
import kotlinx.android.synthetic.main.fragment_phone.view.*

class PhoneFragment : Fragment() {

    private var phoneList = ArrayList<User>()
<<<<<<< HEAD
    private lateinit var database: DatabaseReference

=======

    private lateinit var database: DatabaseReference
>>>>>>> 9de0792135b121a1c2c2128c1776232156b5243c


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_phone, container, false)
        val manager = LinearLayoutManager(this.context)

        view.mRecyclerView.layoutManager = manager
        val adapter = CustomAdapter(phoneList, context!!)
<<<<<<< HEAD
        val REQUEST_CODE = 3

        val fab: View = view.findViewById(R.id.btn)
        fab.setOnClickListener{
            view -> Snackbar.make(view,"plus", Snackbar.LENGTH_LONG).setAction("action", null).show()
            val intent = Intent(activity!!.applicationContext, sub::class.java)
            startActivityForResult(intent,REQUEST_CODE)
        }

=======

        //database = FirebaseDatabase.getInstance().getReference("User")
>>>>>>> 9de0792135b121a1c2c2128c1776232156b5243c
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

<<<<<<< HEAD
        adapter.itemClick= object :CustomAdapter.ItemClick{
            override fun onClick(view: View, position:Int){
                val intent = Intent(context, Info::class.java)
                intent.putExtra("n", phoneList[position].name)
                intent.putExtra("p", phoneList[position].profile)
                intent.putExtra("w", phoneList[position].pw)
                intent.putExtra("position",position)
                startActivityForResult(intent,3)
            }
        }


        return view
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
       super.onActivityResult(requestCode, resultCode, data)

        val adapter = CustomAdapter(phoneList, context!!)

        adapter.itemClick= object :CustomAdapter.ItemClick{
            override fun onClick(view: View, position:Int){
                val intent = Intent(context, Info::class.java)
                intent.putExtra("n", phoneList[position].name)
                intent.putExtra("p", phoneList[position].profile)
                intent.putExtra("w", phoneList[position].pw)
                intent.putExtra("position",position)
                startActivityForResult(intent,3)
            }
        }

        if (requestCode ==3) {
            val str1 = data!!.getStringExtra("fn")
            val str3 = data!!.getStringExtra("pn")
            val position= data!!.getIntExtra("position",100)
            val newuser = User(str1, str3)
            if (str1 != null) {
                if(position ==100) {
                    database.child(str1).setValue(newuser)
                }
                else{
                    database.child(phoneList[position].name!!).setValue(newuser)
                }
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
=======
        return view
    }
>>>>>>> 9de0792135b121a1c2c2128c1776232156b5243c
}
