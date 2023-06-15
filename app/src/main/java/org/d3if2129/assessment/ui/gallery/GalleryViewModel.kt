package org.d3if2129.assessment.ui.gallery

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if2129.assessment.model.Gallery
import org.d3if2129.assessment.network.ApiStatus
import org.d3if2129.assessment.network.HewanApi

class GalleryViewModel : ViewModel() {

    private val data = MutableLiveData<List<Gallery>>()
    private val status = MutableLiveData<ApiStatus>()

    init {
        retrieveData()
    }

    // Data ini akan kita ambil dari server di langkah selanjutnya
    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            status.postValue(ApiStatus.LOADING)
            try {
                data.postValue(HewanApi.service.getHewan())
                status.postValue(ApiStatus.SUCCESS)
            } catch (e: Exception) {
                Log.d("GalleryViewModel", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)
            }
        }
    }

    fun getData(): LiveData<List<Gallery>> = data
    fun getStatus(): LiveData<ApiStatus> = status
}