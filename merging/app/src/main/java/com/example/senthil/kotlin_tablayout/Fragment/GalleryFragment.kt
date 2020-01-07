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
        val adapter = ImageAdapter(this.context!!)

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
        val REQUEST_IMAGE_CAPTURE = 1
        fab.setOnClickListener{
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                takePictureIntent.resolveActivity(activity!!.packageManager)?.also{

                    /**
                     * TRY TO STORE
                     */
                    // to store the image file into the EXTERNAL STORAGE
                    val tmpFile = createImageFile()

                    if (tmpFile != null)
                    {
                        var photoURI = FileProvider.getUriForFile(requireContext(), "com.example.senthil.kotlin_tablayout.fileprovider", tmpFile)
                        //var photoURI = FileProvider.getUriForFile(requireContext(), BuildConfig.APPLICATION_ID + ".fileprovider", tmpFile)
                        //var photoURI = Uri.fromFile(tmpFile)
                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    }

                    /**
                     * END!
                     */

                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            } //captured new image

        }
        view.mRecyclerView2.adapter = adapter

        return view
    }


    //to upload the image to the DB
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val REQUEST_IMAGE_CAPTURE = 1
        val storageRef = FirebaseStorage.getInstance().reference

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK)
        {
            Log.d("###", context.toString())
            var uploadList = GalleryManager(context!!).getAllPhotoPathList()

            for (uploadMe in uploadList)
            {
                var path = uploadMe.imgPath
                var file = FileProvider.getUriForFile(requireContext(), "com.example.senthil.kotlin_tablayout.fileprovider", File(path))

                //var file = Uri.fromFile(File(path))

                //getting when the picture captured
                var time_string = ExifInterface(path).getAttribute(TAG_DATETIME)
                var new_image_name = "Image_" + time_string

                var imageRef = storageRef.child(new_image_name)
                var uploadTask = imageRef.putFile(file)

                uploadTask.addOnFailureListener{
                    Log.e("@@@@", "@@@ NOPE! @@@@")
                }.addOnSuccessListener {
                    val toast1 = Toast.makeText(context, "Uploaded to the SERVER!", Toast.LENGTH_SHORT)
                    toast1.show()
                    //uploaded into the STORAGE
                    //now, start to add the image into the DATABASE

                    var path = imageRef.path

                    storageRef.child(path).downloadUrl.addOnSuccessListener {
                        var uploadMe = Photo(it.toString())
                        database.child(new_image_name).setValue(uploadMe)

                        val toast2 = Toast.makeText(context, "Uploaded to the DATABASE!", Toast.LENGTH_SHORT)
                        toast2.show()
                    }
                }
            }
/*
            val imageBitmap = data!!.extras.get("data") as Bitmap
            imageView1.setImageBitmap(imageBitmap)*/
        }
    }

}
