package com.example.reviewnest_mvp.model

data class MovieDetailsModel(
    val id: String,
    val title: String,
    val landscapeMoviePoster: String,
    val year: String,
    val rating: Double,
    val genres: List<String>,
    val duration: String,
)
