package com.example.examenparcial1_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examenparcial1_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = binding.recyclerView
        recyclerView.adapter = TipoAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}