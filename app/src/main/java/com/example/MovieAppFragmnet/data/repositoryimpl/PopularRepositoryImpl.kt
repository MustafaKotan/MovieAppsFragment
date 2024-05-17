package com.example.MovieAppFragmnet.data.repositoryimpl

import com.example.MovieAppFragmnet.data.apiservice.TMDBApiService
import com.example.MovieAppFragmnet.domain.repository.PopularRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PopularRepositoryImpl(private val api: TMDBApiService): PopularRepository {
    override suspend fun getPopularMovies() = flow {
        val response = api.getPopularMovies()
        emit(response)
    }.flowOn(Dispatchers.IO)
}