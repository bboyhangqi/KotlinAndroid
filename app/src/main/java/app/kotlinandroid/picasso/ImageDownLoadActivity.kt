package app.kotlinandroid.picasso

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import app.kotlinandroid.R
import app.kotlinandroid.extension.loadByPicasso
import kotlinx.android.synthetic.main.activity_image_down_load.*

class ImageDownLoadActivity : AppCompatActivity() {

    private val imageUrl = "https://images.pexels.com/photos/163065/mobile-phone-android-apps-phone-163065.jpeg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_down_load)
        btn_download.setOnClickListener {
            iv_download.loadByPicasso(imageUrl)
        }
    }


}
