package com.magicbytes.mycv

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.magicbytes.mycv.adapter.CvAdapter

// TODO change to support orientation changing, add caching policy
class MainActivity : AppCompatActivity(), com.magicbytes.mycv.View {


    private lateinit var progressLayout: View
    private lateinit var progressBar: View
    private lateinit var messageTextView: TextView
    private lateinit var retryButton: View
    private lateinit var recyclerView: RecyclerView

    private lateinit var presenter: Presenter

    override var isProgressVisible: Boolean = false
        set(value) {
            field = value

            progressBar.visibility = if (value) View.VISIBLE else View.GONE
        }

    override var isErrorVisible: Boolean = false
        set(value) {
            field = value

            messageTextView.visibility = if (value) View.VISIBLE else View.GONE
            retryButton.visibility = if (value) View.VISIBLE else View.GONE
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO move this to App class

        progressLayout = findViewById(R.id.progressLayout)
        progressBar = findViewById(R.id.progressBar)
        messageTextView = findViewById(R.id.messageTextView)
        retryButton = findViewById(R.id.retryButton)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        retryButton.setOnClickListener { presenter.showCv() }

        presenter = Presenter(this, CvNetworkModel())
        presenter.showCv()
    }

    override fun showCv(listItems: List<ListItem>) {
        val adapter = CvAdapter(listItems)
        recyclerView.adapter = adapter
    }
}
