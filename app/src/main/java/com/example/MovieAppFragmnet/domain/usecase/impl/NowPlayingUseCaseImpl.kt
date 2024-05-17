package com.example.MovieAppFragmnet.domain.usecase.impl

import com.example.MovieAppFragmnet.domain.repository.NowPlayingRepository
import com.example.MovieAppFragmnet.domain.usecase.NowPlayingUseCase

class NowPlayingUseCaseImpl(private val repository: NowPlayingRepository): NowPlayingUseCase {
    override suspend fun execute() = repository.getNowPlayingMovies()
}
