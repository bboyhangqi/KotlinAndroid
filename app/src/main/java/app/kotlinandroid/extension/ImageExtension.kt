package app.kotlinandroid.extension

import android.graphics.Bitmap
import android.widget.ImageView
import android.widget.Toast
import app.kotlinandroid.volley.VolleyInstance
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.NetworkImageView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

/**
 * Created by CodingHome on 3/29/18.
 */

fun ImageView.loadByPicasso(url: String) {
    Picasso.with(this.context)
            .load(url)
            .into(this)
}


fun ImageView.loadByGlide(url: String) {
    Glide.with(this.context)
            .asBitmap()
            .load(url)
            .into(this)
}

