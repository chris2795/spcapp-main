package com.example.mis_pc_11.spc_app1.Tourism.Gallery.Videos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.support.v7.widget.LinearLayoutManager
import com.example.mis_pc_11.spc_app1.R
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_videos.*
import okhttp3.*
import java.io.IOException

class ActivityVideos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videos)

        recycler_video.layoutManager = LinearLayoutManager(this)
      //  recycler_video.adapter = VideoAdapter()



        fetchJson()
    }
    fun fetchJson(){
        println("Attempting to Fetch Json")

        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback{
            override fun onResponse(call: Call, response: Response) {
                val body = response.body()?.string()
                println(body)

                val gson = GsonBuilder().create()

                val homeFeed = gson.fromJson(body, HomeFeed::class.java)

                runOnUiThread {
                    recycler_video.adapter =
                        VideoAdapter(homeFeed)
                }

            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
                }
        })
    }

}


