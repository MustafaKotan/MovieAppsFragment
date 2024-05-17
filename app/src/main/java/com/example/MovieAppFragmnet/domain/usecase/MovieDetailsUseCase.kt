package com.example.MovieAppFragmnet.domain.usecase

import com.example.MovieAppFragmnet.data.Movie
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface MovieDetailsUseCase {
    suspend fun execute(movieId: Int): Flow<Response<Movie>>
}