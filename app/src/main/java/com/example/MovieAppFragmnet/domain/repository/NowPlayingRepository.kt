package com.example.MovieAppFragmnet.domain.repository

import com.example.MovieAppFragmnet.data.Movie
import com.example.MovieAppFragmnet.data.MovieData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface NowPlayingRepository {

    suspend fun getNowPlayingMovies(): Flow<Response<MovieData<Movie>>>
}
