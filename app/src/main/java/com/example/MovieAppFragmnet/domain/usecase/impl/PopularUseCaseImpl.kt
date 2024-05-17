package com.example.MovieAppFragmnet.domain.usecase.impl

import com.example.MovieAppFragmnet.domain.repository.PopularRepository
import com.example.MovieAppFragmnet.domain.usecase.PopularUseCase

class PopularUseCaseImpl(private val repository: PopularRepository): PopularUseCase {
    override suspend fun execute() = repository.getPopularMovies()
}