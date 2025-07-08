package com.example.reviewnest_mvp.network.api

import com.example.reviewnest_mvp.mappers.toMovieDetailsModel
import com.example.reviewnest_mvp.model.MovieListItemModel
import com.example.reviewnest_mvp.mappers.toMoviesModelList
import com.example.reviewnest_mvp.model.MovieDetailsModel

class TMBdApiProvider(private val apiKey: String) {
    suspend fun getMovies(): List<MovieListItemModel> {
        val response = TMDbApiClient.api.getPopularMovies(apiKey)
        return response.results.toMoviesModelList()
    }

    suspend fun getMovieDetails(movieId: Int): MovieDetailsModel {
        val response = TMDbApiClient.api.getMovieDetails(movieId, apiKey)
        return response.toMovieDetailsModel()
    }
}
