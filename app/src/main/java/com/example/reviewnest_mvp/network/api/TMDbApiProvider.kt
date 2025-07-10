package com.example.reviewnest_mvp.network.api

import com.example.reviewnest_mvp.mappers.toCastMemberModel
import com.example.reviewnest_mvp.mappers.toMovieDetailsModel
import com.example.reviewnest_mvp.model.MovieListItemModel
import com.example.reviewnest_mvp.mappers.toMoviesModelList
import com.example.reviewnest_mvp.model.MovieDetailsModel

class TMDbApiProvider(private val apiKey: String) {
    suspend fun getMovies(): List<MovieListItemModel> {
        val response = TMDbApiClient.api.getPopularMovies(apiKey)
        return response.results.toMoviesModelList()
    }

    suspend fun getMovieDetails(movieId: Int): MovieDetailsModel {
        val detailsResponse = TMDbApiClient.api.getMovieDetails(movieId, apiKey)
        val castResponse = TMDbApiClient.api.getMovieCast(movieId, apiKey)
        val castModels = castResponse.cast.map { it.toCastMemberModel() }
        return detailsResponse.toMovieDetailsModel(cast = castModels)

    }
}
