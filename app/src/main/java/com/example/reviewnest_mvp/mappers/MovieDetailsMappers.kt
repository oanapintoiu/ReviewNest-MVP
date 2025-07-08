package com.example.reviewnest_mvp.mappers

import com.example.reviewnest_mvp.model.MovieDetailsModel
import com.example.reviewnest_mvp.network.dto.MovieDetailsDTO

fun MovieDetailsDTO.toMovieDetailsModel(
ageRating: String = ""
): MovieDetailsModel = MovieDetailsModel(
    id = id.toString(),
    title = title,
    landscapeMoviePoster = backdropPath?.let { "https://image.tmdb.org/t/p/w780$it" } ?: "",
    year = releaseYear?.take(4) ?: "",
    rating = voteAverage,
    genres = genres.map { it.name },
    duration = runtime?.let { "${runtime / 60}h ${runtime % 60}m" } ?: "",
    ageRating = ageRating,
)
