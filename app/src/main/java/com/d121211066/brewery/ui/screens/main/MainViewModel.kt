package com.d121211066.brewery.ui.screens.main

import com.d121211066.brewery.data.repository.BreweryRepository

sealed interface MainUiState {
    data class Success(val brewery: List<Article>) : MainUiState
    object Error : MainUiState
    object Loading : MainUiState
}

class MainViewModel(private val breweryRepository: BreweryRepository): ViewModel() {

    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    fun getBrewery() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            val result = breweryRepository.getBrewery(
                q = "pemilu",
                from = "2023-10-15",
                sortBy = "publishedAt"
            )
            Log.d("MainViewModel", "getBrewery: ${result.articles?.size}")
            mainUiState = MainUiState.Success(result.articles.orEmpty())
        } catch (e: IOException) {
            Log.d("MainViewMode", "getBrewery error: ${e.message}")
            mainUiState = MainUiState.Error
        }
    }

    init {
        getBrewery()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MyApplication)
                val breweryRepository = application.container.breweryRepository
                MainViewModel(breweryRepository)
            }
        }
    }

}