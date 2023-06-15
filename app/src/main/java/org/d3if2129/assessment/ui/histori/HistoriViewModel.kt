package org.d3if2129.assessment.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if2129.assessment.db.HewanDao

class HistoriViewModel(private  val db: HewanDao) : ViewModel() {
    val data = db.getLastBmi()

    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.clearData()
        }
    }
}