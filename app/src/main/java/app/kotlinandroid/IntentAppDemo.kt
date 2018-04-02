package app.kotlinandroid

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_intent_app_demo.*

class IntentAppDemo : AppCompatActivity(), View.OnClickListener {

    val REQUEST_VIDEO_APP_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_app_demo)

        button2.setOnClickListener(this)
        video_view.setOnCompletionListener {
            button2.visibility = View.VISIBLE
        }

    }


    override fun onClick(v: View?) {
        val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
        if (intent.resolveActivity(packageManager) != null)
            startActivityForResult(intent, REQUEST_VIDEO_APP_CODE)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            REQUEST_VIDEO_APP_CODE -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    video_view.setVideoURI(data.data)
                    button2.visibility = View.GONE
                    video_view.start()
                }
            }
            else -> {
                Toast.makeText(this, "Unrecgnized request code", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
