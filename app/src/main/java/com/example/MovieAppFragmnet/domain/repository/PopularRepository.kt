package com.example.MovieAppFragmnet.domain.repository

import com.example.MovieAppFragmnet.data.Movie
import com.example.MovieAppFragmnet.data.MovieData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface PopularRepository {

    suspend fun getPopularMovies(): Flow<Response<MovieData<Movie>>>
}