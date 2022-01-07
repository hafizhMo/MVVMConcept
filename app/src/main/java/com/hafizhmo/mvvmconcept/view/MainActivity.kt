package com.hafizhmo.mvvmconcept.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.hafizhmo.mvvmconcept.databinding.ActivityMainBinding
import com.hafizhmo.mvvmconcept.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.getCharacter()!!.observe(this, { characterResponse ->
            binding.characterRecycler.apply {
                adapter = MainAdapter(this@MainActivity, characterResponse)
                layoutManager = GridLayoutManager(this@MainActivity, 3)
            }
        })
    }

}