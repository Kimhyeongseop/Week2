package com.example.senthil.kotlin_tablayout.Fragment

import android.os.Bundle
import android.provider.ContactsContract
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.senthil.kotlin_tablayout.Address

import com.example.senthil.kotlin_tablayout.R
import com.example.senthil.kotlin_tablayout.RecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_address.*

class AddressFragment : Fragment() {

    private var addressList = mutableListOf<Address>()
    //private lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadAddress()
        //setHasOptionsMenu(true)
    }

    private fun loadAddress() {
        /*
        addressList.add(Address("Police", "112"))
        addressList.add(Address("Ahn Jaewoong", "010-7392-2367"))
        addressList.add(Address("asdf", "010-1234-5678"))
         */

        val uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        val projection = arrayOf(ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                //ContactsContract.CommonDataKinds.Phone.PHOTO_ID
        )

        val selectionArgs = null
        val sortOrder = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " COLLATE LOCALIZED ASC"

        val contactCursor = context?.contentResolver!!.query(uri, projection, null, selectionArgs, sortOrder)

        if (contactCursor!!.moveToFirst()) {
            do {
                val phoneNum = contactCursor.getString(1).replace("-","")
                var number = ""

                if (phoneNum.length == 10) {
                    number = phoneNum.substring(0, 3) + "-" +
                            phoneNum.substring(3, 6) + "-" +
                            phoneNum.substring(6)
                }
                else if (phoneNum.length > 8) {
                    number = phoneNum.substring(0, 3) + "-" +
                            phoneNum.substring(3, 7) + "-" +
                            phoneNum.substring(7)
                }

                val id = contactCursor.getLong(0)
                val name = contactCursor.getString(2)
                //val image = contactCursor.getShort(3)

                val address = Address(id, number, name)
                addressList.add(address)

            } while (contactCursor.moveToNext())
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mRecyclerView?.layoutManager = LinearLayoutManager(this.context)
        mRecyclerView?.adapter = RecyclerViewAdapter(addressList)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_address, container, false)
        return view
    }
}
