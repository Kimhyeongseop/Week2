package com.example.senthil.kotlin_tablayout

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore

class GalleryManager { //사진정보를 가져옴
    private var mContext: Context

    constructor(context: Context)
    {
        mContext = context
    }
//      * 갤러리 이미지 반환
//     *
//             * @return
//             */
    fun getAllPhotoPathList() : List<PhotoVO>
    {

        var photoList : ArrayList<PhotoVO> = ArrayList<PhotoVO>()

        val uri = android . provider . MediaStore . Images . Media . EXTERNAL_CONTENT_URI
        // 안드로이드 시스템에서 제공하는 미디어 데이터 DB

        val projection : Array<String> = arrayOf(
            MediaStore.MediaColumns.DATA,
            MediaStore.Images.Media.DATE_ADDED)

        var cursor: Cursor = mContext.getContentResolver().query(uri, projection, null, null, null);
        // 그 안에서의 이동 및 쿼리, 다 가져옴

        var columnIndexData = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA)

        while (cursor.moveToNext())
        {
            val photoVO = PhotoVO(cursor.getString(columnIndexData))
            photoList.add(photoVO) //채워줌
        }

        cursor.close()

        return photoList
    }
}