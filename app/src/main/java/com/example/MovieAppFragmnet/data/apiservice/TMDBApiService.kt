package com.example.MovieAppFragmnet.data.apiservice

import com.example.MovieAppFragmnet.data.Movie
import com.example.MovieAppFragmnet.data.MovieData
import com.example.MovieAppFragmnet.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TMDBApiService {

    @GET("/3/movie/now_playing?api_key=${Constants.API_KEY}&language=en-US&page=1")
    suspend fun getNowPlayingMovies(): Response<MovieData<Movie>>

    @GET("/3/movie/popular?api_key=${Constants.API_KEY}&language=en-US&page=1")
    suspend fun getPopularMovies(): Response<MovieData<Movie>>

    @GET("/3/movie/{movie_id}?api_key=${Constants.API_KEY}&language=en-US")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int
    ): Response<Movie>
}
