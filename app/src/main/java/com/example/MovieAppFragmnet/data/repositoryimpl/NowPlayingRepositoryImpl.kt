package com.example.MovieAppFragmnet.data.repositoryimpl

import com.example.MovieAppFragmnet.data.apiservice.TMDBApiService
import com.example.MovieAppFragmnet.domain.repository.NowPlayingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class NowPlayingRepositoryImpl(private val api: TMDBApiService): NowPlayingRepository {
    override suspend fun getNowPlayingMovies() = flow {
        val response = api.getNowPlayingMovies()
        emit(response)
    }.flowOn(Dispatchers.IO)
}
