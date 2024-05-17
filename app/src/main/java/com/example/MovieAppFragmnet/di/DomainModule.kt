package com.example.MovieAppFragmnet.di

import com.example.MovieAppFragmnet.domain.usecase.MovieDetailsUseCase
import com.example.MovieAppFragmnet.domain.usecase.NowPlayingUseCase
import com.example.MovieAppFragmnet.domain.usecase.PopularUseCase
import com.example.MovieAppFragmnet.domain.usecase.impl.MovieDetailsUseCaseImpl
import com.example.MovieAppFragmnet.domain.usecase.impl.NowPlayingUseCaseImpl
import com.example.MovieAppFragmnet.domain.usecase.impl.PopularUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<NowPlayingUseCase> {
        NowPlayingUseCaseImpl(repository = get())
    }

    factory<PopularUseCase> {
        PopularUseCaseImpl(repository = get())
    }


    factory<MovieDetailsUseCase> {
        MovieDetailsUseCaseImpl(repository = get())
    }
}
