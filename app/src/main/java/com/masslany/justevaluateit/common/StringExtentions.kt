package com.masslany.justevaluateit.common

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64

fun String.decodeBase64IntoBitmap(): Bitmap {
    val imageBytes = Base64.decode(this, Base64.DEFAULT)
    return BitmapFactory.decodeByteArray(
        imageBytes, 0, imageBytes.size
    )
}
