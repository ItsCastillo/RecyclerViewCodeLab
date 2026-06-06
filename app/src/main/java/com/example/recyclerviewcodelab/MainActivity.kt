package com.example.recyclerviewcodelab

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewcodelab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var courseAdapter: CourseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        loadInitialData()
    }

    private fun setupRecyclerView() {

        courseAdapter = CourseAdapter { selectedCourse ->

            Toast.makeText(
                this,
                "Seleccionado: ${selectedCourse.title}",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.recyclerViewCourses.apply {

            layoutManager =
                LinearLayoutManager(this@MainActivity)

            adapter = courseAdapter

            setHasFixedSize(true)
        }
    }

    private fun loadInitialData() {

        val courses = listOf(
            Course(1, "Kotlin Desde Cero", "Programación", "Básico"),
            Course(2, "Arquitectura MVVM", "Arquitectura", "Intermedio"),
            Course(3, "Master en RecyclerView", "UI/UX", "Avanzado"),
            Course(4, "Inyección de Dependencias", "Arquitectura", "Avanzado"),
            Course(5, "Corrutinas en Android", "Concurrencia", "Intermedio")
        )

        courseAdapter.submitList(courses)
    }
}
