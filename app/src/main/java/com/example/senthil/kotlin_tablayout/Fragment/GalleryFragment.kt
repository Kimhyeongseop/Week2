package com.example.senthil.kotlin_tablayout.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.senthil.kotlin_tablayout.GridViewAdapter
import com.example.senthil.kotlin_tablayout.R
import kotlinx.android.synthetic.main.fragment_gallery.*

class GalleryFragment : Fragment()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        listing?.adapter = GridViewAdapter(requireContext())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        return root
    }
}



