package com.example.MovieAppFragmnet.di

import com.example.MovieAppFragmnet.presentation.viewmodel.MovieDetailsViewModel
import com.example.MovieAppFragmnet.presentation.viewmodel.NowPlayingViewModel
import com.example.MovieAppFragmnet.presentation.viewmodel.PopularViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        NowPlayingViewModel(useCase = get())
    }

    viewModel {
        PopularViewModel(useCase = get())
    }



    viewModel {
        MovieDetailsViewModel(useCase = get())
    }
}
