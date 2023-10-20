package com.example.albondigas.presetation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.albondigas.app.ErrorApp
import com.example.albondigas.domain.GetTapasUseCase
import com.example.albondigas.domain.Tapas
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ComidaViewModel(private val getTapasUseCase: GetTapasUseCase): ViewModel() {
    private val _uiModel = MutableLiveData<UiModel>()
    val uiModel: LiveData<UiModel> =_uiModel

    fun loadTapas(){
        _uiModel.value = UiModel(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            getTapasUseCase().fold(
                {responseError(it)},
                {responseSuccess(it)}
            )
        }
    }
    private fun responseError(error: ErrorApp) {
        _uiModel.postValue(UiModel(error = error))
    }

    private fun responseSuccess(tapas: Tapas) {
        _uiModel.postValue(UiModel(tapas = tapas))
    }

    data class UiModel(
        val isLoading: Boolean = false,
        val error: ErrorApp? = null,
        val tapas: Tapas? = null
    )
}