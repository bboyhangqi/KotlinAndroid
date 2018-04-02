package app.kotlinandroid.volley

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import app.kotlinandroid.R
import kotlinx.android.synthetic.main.activity_image_down_load_volley.*

class ImageDownLoadActivity : AppCompatActivity() {

    private val imageUrl = "https://images.pexels.com/photos/163065/mobile-phone-android-apps-phone-163065.jpeg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_down_load_volley)
        btn_download.setOnClickListener {
            net_iv_download.setImageUrl(imageUrl,VolleyInstance.getInstance(this.applicationContext).ivLoader)
        }
    }

}
