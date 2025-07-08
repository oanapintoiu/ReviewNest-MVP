package com.example.reviewnest_mvp.network.api

import com.example.reviewnest_mvp.network.dto.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDbApi {
    @GET("movie/top_rated")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): MoviesResponse
}
