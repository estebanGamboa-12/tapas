package com.example.albondigas.presetation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.albondigas.R
import com.example.albondigas.app.ErrorApp
import com.example.albondigas.data.TapasDataRepository
import com.example.albondigas.data.local.TapasLocalDataSource
import com.example.albondigas.data.remote.TapasRemoteDataSource
import com.example.albondigas.databinding.ActivityMainBinding
import com.example.albondigas.domain.GetTapasUseCase
import com.example.albondigas.domain.Tapas
import com.example.albondigas.app.extension.load

import com.faltenreich.skeletonlayout.Skeleton
import com.google.android.material.snackbar.Snackbar
import com.iesam.androidviews.app.serialization.GsonSerialization


class ComidaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: ComidaViewModel by lazy {
        ComidaViewModel(
            GetTapasUseCase(
                TapasDataRepository(
                    TapasLocalDataSource(
                        this,
                        GsonSerialization()
                    ), TapasRemoteDataSource()
                )
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBinding()
        setupView()
        setUpObserver()
        viewModel.loadTapas()

    }

    private lateinit var skeleton: Skeleton
    private fun setupView() {
        skeleton = binding.layoutSkeleton
    }

    private fun setUpObserver() {
        val observer = Observer<ComidaViewModel.UiModel> { uiModel ->
            if (uiModel.isLoading) {
                showLoading()
            } else {
                hideLoading()
            }

            uiModel.error?.let {
                showError(it)
            }
            uiModel.tapas?.let {
                bindData(it)
            }

        }
        viewModel.uiModel.observe(this,observer)
    }

    private fun showError(error: ErrorApp) {
        Snackbar.make(
            binding.root,
            getString(R.string.error),
            Snackbar.LENGTH_SHORT
        ).show()
    }

    private fun showLoading() {
        skeleton.showSkeleton()
    }

    private fun hideLoading() {
        skeleton.showOriginal()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun bindData(tapas: Tapas) {
        binding.apply {
            image.load(tapas.urlImage)
            parrafo1.text = tapas.title
            numero.text = tapas.number
            parrafo2.text = tapas.description
            total.text = tapas.total
            media.text = tapas.media
            compartir.load(tapas.urlCompartir)
            like.load(tapas.urlLike)
        }
    }


}


