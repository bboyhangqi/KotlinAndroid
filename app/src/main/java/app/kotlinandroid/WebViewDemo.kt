package app.kotlinandroid

import android.annotation.SuppressLint
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web_view_demo.*

class WebViewDemo : AppCompatActivity() ,OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_demo)
        btn_search.setOnClickListener(this)
    }

    private fun getUri(authority: String): Uri {
        val builder = Uri.Builder()
        builder.scheme("https")
                .authority(authority)
        return builder.build()
    }

    override fun onClick(v: View?) {
        fetchWeb()
    }

    override fun onBackPressed() {
        //super.onBackPressed()
        web_view.goBack()
    }


    @SuppressLint("SetJavaScriptEnabled")
    private fun fetchWeb() {
        web_view.loadUrl("")
        web_view.settings.javaScriptEnabled = true
        web_view.webViewClient = WebViewClient()

        Log.d("zhq.debug ", edit_addr.text.toString())
        val uri = getUri(edit_addr.text.toString())
        web_view.loadUrl(uri.toString())
    }


}
