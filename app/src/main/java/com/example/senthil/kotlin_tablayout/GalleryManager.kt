package com.example.senthil.kotlin_tablayout

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.core.content.FileProvider
import java.io.File

class GalleryManager {
    private var mContext : Context

    constructor(context: Context){
        mContext = context
    }

    fun getAllPhotoPathList() : List<PhotoVO>
    {

        var photoList : ArrayList<PhotoVO> = ArrayList<PhotoVO> ()

        //val tmp = Environment.getDataDirectory().absolutePath
        //val uri = Uri.parse(tmp + "/files/Pictures")

        //val string = mContext.dataDir.absolutePath
/*
        val imagePath = File(mContext.filesDir, "/Pictures")
        Log.d("###", imagePath.absolutePath.toString())
       // val uri = FileProvider.getUriForFile(mContext, "com.example.senthil.kotlin_tablayout.fileprovider", imagePath)
        val tmp = mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val uri = Uri.parse(tmp.absolutePath)
        Log.d("%%%", uri.toString())*/
        //val uri = Uri.parse("/Android/data/data/com.example.senthil.kotlin_tablayout/files/Pictures")
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        //안드로이드 시스템에서 제공하는 미디어 데이터 DB

        val projection : Array<String> = arrayOf(
                MediaStore.MediaColumns.DATA,
                MediaStore.Images.Media.DATE_ADDED
        )

        Log.e("###### ", "IN MANAGER, mContext: " + mContext.toString() + ", uri: " + uri.toString())
        var cursor: Cursor = mContext!!.contentResolver.query(uri, projection, null, null, null)

        var columnIndexData = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA)

        while(cursor.moveToNext())
        {
            val photoVO = PhotoVO(cursor.getString(columnIndexData!!))
            photoList.add(photoVO)
        }

        cursor.close()

        return photoList
    }
}