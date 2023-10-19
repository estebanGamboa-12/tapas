package com.example.albondigas.presetation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.albondigas.R
import com.example.albondigas.databinding.ActivityMainBinding
import com.faltenreich.skeletonlayout.Skeleton


class ComidaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    private lateinit var skeleton: Skeleton
    private fun setupView(){
        skeleton=binding.layoutSkeleton
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}