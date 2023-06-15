package org.d3if2129.assessment.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if2129.assessment.db.HewanDao

class HomeViewModelFactory(
    private val db: HewanDao
    ) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}