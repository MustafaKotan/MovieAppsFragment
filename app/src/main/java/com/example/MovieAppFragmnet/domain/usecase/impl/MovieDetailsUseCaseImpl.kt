package com.example.MovieAppFragmnet.domain.usecase.impl

import com.example.MovieAppFragmnet.domain.repository.MovieDetailsRepository
import com.example.MovieAppFragmnet.domain.usecase.MovieDetailsUseCase

class MovieDetailsUseCaseImpl(private val repository: MovieDetailsRepository): MovieDetailsUseCase {
    override suspend fun execute(movieId: Int) = repository.getMovieDetails(movieId)
}