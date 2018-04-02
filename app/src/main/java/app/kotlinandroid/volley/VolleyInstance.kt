package app.kotlinandroid.volley

import android.content.Context
import android.graphics.Bitmap
import android.util.LruCache
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.Volley

/**
 * Created by CodingHome on 3/29/18.
 */
class VolleyInstance(contex: Context) {

    companion object {
        private val INSTANCE: VolleyInstance? = null

        fun getInstance(context: Context) = INSTANCE ?: synchronized(this) {
            INSTANCE ?: VolleyInstance(context)
        }
    }

    val requestQueue by lazy {
        Volley.newRequestQueue(contex.applicationContext)
    }

    val ivLoader by lazy {
        ImageLoader(requestQueue, MyImageCache())
    }


    private class MyImageCache : ImageLoader.ImageCache {

        private val cache = LruCache<String, Bitmap>(20)

        override fun getBitmap(url: String?): Bitmap {
            System.out.println(url)
            System.out.println(cache)
            return cache.get(url)
        }

        override fun putBitmap(url: String?, bitmap: Bitmap?) {
            System.out.println("putBitmap")
            cache.put(url, bitmap)
        }
    }

    fun <T> addRequest(request: Request<T>) {
        requestQueue.add(request)
    }

}