package com.example.MovieAppFragmnet.data.repositoryimpl

import com.example.MovieAppFragmnet.data.apiservice.TMDBApiService
import com.example.MovieAppFragmnet.domain.repository.MovieDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MovieDetailsRepositoryImpl(private val api: TMDBApiService): MovieDetailsRepository {

    override suspend fun getMovieDetails(movieId: Int) = flow {
        val response = api.getMovieDetails(movieId)
        emit(response)
    }.flowOn(Dispatchers.IO)
}
