package com.segunfrancis.zooanimals.ui.layout.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.segunfrancis.zooanimals.data.ZooAnimalApi
import com.segunfrancis.zooanimals.util.ZooState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(private val api: ZooAnimalApi) : ViewModel() {

    private val _zooResponse = MutableStateFlow<ZooState>(ZooState.Loading)
    val zooResponse: StateFlow<ZooState> = _zooResponse

    private val exception = CoroutineExceptionHandler { _, throwable ->
        _zooResponse.value = ZooState.Error(error = throwable)
        Log.e("HomeViewModel", throwable.localizedMessage!!)
    }

    init {
        getZooAnimals()
    }

    fun getZooAnimals() {
        viewModelScope.launch(exception) {
            _zooResponse.value = ZooState.Loading
            val response = withContext(Dispatchers.IO) {
                api.getRandomAnimals()
            }
            _zooResponse.value = ZooState.Success(data = response)
        }
    }
}

@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory(private val api: ZooAnimalApi) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            HomeViewModel(api) as T
        } else {
            throw IllegalArgumentException("Cannot create instance of ${modelClass.canonicalName}")
        }
    }
}
