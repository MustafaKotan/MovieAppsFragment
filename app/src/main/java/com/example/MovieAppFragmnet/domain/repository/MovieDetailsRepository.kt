package com.example.MovieAppFragmnet.domain.repository

import com.example.MovieAppFragmnet.data.Movie
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface MovieDetailsRepository {

    suspend fun getMovieDetails(movieId: Int): Flow<Response<Movie>>
}