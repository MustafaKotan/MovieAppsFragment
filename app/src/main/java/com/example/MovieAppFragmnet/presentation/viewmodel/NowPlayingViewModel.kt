package com.example.MovieAppFragmnet.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.MovieAppFragmnet.data.Movie
import com.example.MovieAppFragmnet.domain.usecase.NowPlayingUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.catch
import org.json.JSONObject

class NowPlayingViewModel(private val useCase: NowPlayingUseCase): ViewModel() {

    private val _successFlow = MutableSharedFlow<List<Movie>>()
    val successFlow get() = _successFlow

    private val _messageFlow = MutableSharedFlow<String>()
    val messageFlow get() = _messageFlow

    private val _errorFlow = MutableSharedFlow<String>()
    val errorFlow get() = _errorFlow

    suspend fun getNowPlayingMovies() {
        useCase.execute()
            .catch {
                it.printStackTrace()
                _errorFlow.emit(it.localizedMessage ?: "Server eror")
            }
            .collect {
                if (it.isSuccessful) {
                    _successFlow.emit(it.body()!!.results)
                } else {
                    val errorObj = it.errorBody()?.charStream()?.readText()
                        ?.let { it1 -> JSONObject(it1) }
                    val message = errorObj?.getJSONObject("status_message")?.getString("status_message")
                        ?: "Server eror"
                    _messageFlow.emit(message)
                }
            }
    }
}
