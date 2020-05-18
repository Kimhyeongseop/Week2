package com.example.senthil.kotlin_tablayout.Fragment

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.media.ExifInterface
import android.media.ExifInterface.TAG_DATETIME
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.os.Environment.DIRECTORY_PICTURES
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.senthil.kotlin_tablayout.*
import com.example.senthil.kotlin_tablayout.BuildConfig
import com.example.senthil.kotlin_tablayout.R
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.fragment_gallery.view.*
import kotlinx.android.synthetic.main.item_gallery.*
import java.io.File
import java.io.FilePermission
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class GalleryFragment : Fragment() {

    private var currentPhotoPath : String = ""
    private var imageList = ArrayList<Photo>()
    private lateinit var database: DatabaseReference

    fun createImageFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir = activity!!.getExternalFilesDir(DIRECTORY_PICTURES)
        //val storageDir = File(Environment.getExternalStorageDirectory(), timeStamp)

        return File.createTempFile(
                "${timeStamp}", /* prefix */
                ".jpg", /* suffix */
                storageDir /* directory */
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            currentPhotoPath = absolutePath
            //currentPhotoPath = absolutePath
        } }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
    {
        database = FirebaseDatabase.getInstance().getReference("Gallery")

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)
        val manager = LinearLayoutManager(this.context)

        view.mRecyclerView2.layoutManager = manager
        val adapter = ImageAdapter(imageList, this.context!!)

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(shot: DataSnapshot)
            {
                imageList.clear()
                for (snapshot in shot.getChildren()) {

                    var image = snapshot.getValue(Photo::class.java)

                    imageList.add(image!!)
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(p0: DatabaseError) {
                Log.e("TAG",  "@@@@ ERROR while get data from the database")
            }
        })

        //for FAB
        val fab: View = view!!.findViewById(R.id.gallery_fab)
        var REQUEST_IMAGE_CAPTURE = 0
        fab.setOnClickListener{
            REQUEST_IMAGE_CAPTURE = 1
            Toast.makeText(activity!!.applicationContext, "업로드 시작!", Toast.LENGTH_SHORT).show()

            val storageRef = FirebaseStorage.getInstance().reference

            Log.d("###", context.toString())
            var uploadList = GalleryManager(context!!).getAllPhotoPathList()

            if (REQUEST_IMAGE_CAPTURE == 1) {
                for (uploadMe in uploadList) {
                    var path = uploadMe.imgPath
                    var file = FileProvider.getUriForFile(requireContext(), "com.example.senthil.kotlin_tablayout.fileprovider", File(path))

                    //var file = Uri.fromFile(File(path))

                    //getting when the picture captured
                    var time_string = ExifInterface(path).getAttribute(TAG_DATETIME)
                    var new_image_name = "Image_" + time_string

                    var imageRef = storageRef.child(new_image_name)
                    var uploadTask = imageRef.putFile(file)

                    uploadTask.addOnFailureListener {
                        Log.e("@@@@", "@@@ NOPE! @@@@")
                    }.addOnSuccessListener {
                        //uploaded into the STORAGE
                        //now, start to add the image into the DATABASE

                        var path = imageRef.path

                        storageRef.child(path).downloadUrl.addOnSuccessListener {
                            var uploadMe = Photo(it.toString())
                            database.child(new_image_name).setValue(uploadMe)
                        }
                    }

                }

                Toast.makeText(context, "업로드 성공!", Toast.LENGTH_SHORT).show()
            }

        }

        view.mRecyclerView2.adapter = adapter

        return view
    }
}
