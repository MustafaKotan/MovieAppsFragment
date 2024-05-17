package com.example.MovieAppFragmnet.di

import com.example.MovieAppFragmnet.data.repositoryimpl.MovieDetailsRepositoryImpl
import com.example.MovieAppFragmnet.data.repositoryimpl.NowPlayingRepositoryImpl
import com.example.MovieAppFragmnet.data.repositoryimpl.PopularRepositoryImpl
import com.example.MovieAppFragmnet.domain.repository.MovieDetailsRepository
import com.example.MovieAppFragmnet.domain.repository.NowPlayingRepository
import com.example.MovieAppFragmnet.domain.repository.PopularRepository
import org.koin.dsl.module

val dataModule = module {
    single<NowPlayingRepository> {
        NowPlayingRepositoryImpl(api = get())
    }

    single<PopularRepository> {
        PopularRepositoryImpl(api = get())
    }



    single<MovieDetailsRepository> {
        MovieDetailsRepositoryImpl(api = get())
    }
}