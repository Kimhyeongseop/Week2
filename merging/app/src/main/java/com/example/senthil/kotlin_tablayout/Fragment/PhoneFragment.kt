package com.example.senthil.kotlin_tablayout.Fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.senthil.kotlin_tablayout.*
import com.example.senthil.kotlin_tablayout.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.*
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

        database = FirebaseDatabase.getInstance().getReference("User")

        val fab: View = view.findViewById(R.id.btn) // 추가버튼
        fab.setOnClickListener {
            val intent = Intent(activity!!.applicationContext, sub::class.java)
            startActivityForResult(intent,3)
        }

//데이터 베이스에서 정보를 빼옴
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

        adapter.itemClick= object :CustomAdapter.ItemClick{ // info
            override fun onClick(view: View, position:Int){
                val intent = Intent(context, Info::class.java)
                intent.putExtra("id", phoneList[position].name)
                intent.putExtra("photo", phoneList[position].profile)
                intent.putExtra("pw", phoneList[position].pw)
                intent.putExtra("position",position)
                startActivityForResult(intent,3)
            }
        }


        return view
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
       super.onActivityResult(requestCode, resultCode, data)

        val adapter = CustomAdapter(phoneList, context!!)

        adapter.itemClick= object :CustomAdapter.ItemClick{ //info로 이동
            override fun onClick(view: View, position:Int){
                val intent = Intent(context, Info::class.java)
                intent.putExtra("id", phoneList[position].name)
                intent.putExtra("photo", phoneList[position].profile)
                intent.putExtra("pw", phoneList[position].pw)
                intent.putExtra("position",position)
                startActivityForResult(intent,3)
            }
        }

        if (requestCode ==3) {
            val id = data!!.getStringExtra("id")
            val pw = data!!.getStringExtra("pw")
            val position= data!!.getIntExtra("position",100)
            val newuser = User(id, pw)
            if (id != null) {
                if(position ==100) { //추가
                    database.child(id).setValue(newuser)
                }
                else{ //변경
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
}
