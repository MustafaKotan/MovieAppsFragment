package com.example.MovieAppFragmnet.domain.usecase

import com.example.MovieAppFragmnet.data.Movie
import com.example.MovieAppFragmnet.data.MovieData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface NowPlayingUseCase {

    suspend fun execute(): Flow<Response<MovieData<Movie>>>
}