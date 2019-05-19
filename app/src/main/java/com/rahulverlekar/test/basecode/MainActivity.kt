package com.rahulverlekar.test.basecode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.rahulverlekar.test.basecode.model.Post
import com.rahulverlekar.test.basecode.ui.RecyclerViewCallback
import com.rahulverlekar.test.basecode.ui.addDataSource
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RecyclerViewCallback {
    var listOfPosts = arrayListOf(
        Post(1, "URL1"),
        Post(2, "URL2"),
        Post(3, "URL3"),
        Post(3, "URL3"),
        Post(3, "URL3"),
        Post(3, "URL3"),
        Post(3, "URL3"),
        Post(3, "URL3"),
        Post(3, "URL3"),
        Post(3, "URL3"),
        Post(3, "URL3"),
        Post(3, "URL3"),
        Post(3, "URL3"),
        Post(3, "URL3"),
        Post(3, "URL3"),
        Post(3, "URL3"),
        Post(3, "URL3"),
        Post(3, "URL3"),
        Post(3, "URL3"),
        Post(3, "URL3"),
        Post(3, "URL3"),
        Post(3, "URL3"),
        Post(3, "URL3"),
        Post(4, "URL4")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_posts.addDataSource(listOfPosts, R.layout.item_post_summary, this)
    }

    fun clicked(v: View) {
//        Toast.makeText(this, p.url, Toast.LENGTH_SHORT).show()
    }
    public fun postClicked(p: Post) {
        Toast.makeText(this, p.url, Toast.LENGTH_SHORT).show()
    }
}
