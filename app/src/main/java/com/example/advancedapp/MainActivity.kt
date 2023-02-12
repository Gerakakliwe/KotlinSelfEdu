package com.example.advancedapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.advancedapp.model.RecyclerList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initInputFieldSearchButton()
        initRecyclerView()
        initViewModel()

        searchButton.setOnClickListener {
            val inputText = searchText.text.toString()
            if (inputText.isNotEmpty()) {
                Toast.makeText(this, inputText, Toast.LENGTH_SHORT).show()
                mainActivityViewModel.makeApiCall(inputText)
            }
        }
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter = RecyclerViewAdapter()
        recyclerView.adapter = recyclerViewAdapter
    }

    private fun initViewModel() {
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.getLiveDataObserver().observe(this, object : Observer<RecyclerList>{
            override fun onChanged(t: RecyclerList?) {
                if (t != null) {
                    recyclerViewAdapter.setUpdatedData(t.items)
                    recyclerViewAdapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(this@MainActivity, "Error in getting the data", Toast.LENGTH_SHORT).show()
                }
            }
        })
        mainActivityViewModel.makeApiCall()
    }

    private fun initInputFieldSearchButton() {
        searchText
        searchButton
    }
}