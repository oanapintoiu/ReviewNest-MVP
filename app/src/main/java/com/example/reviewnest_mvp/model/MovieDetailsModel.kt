package com.example.reviewnest_mvp.model

data class MovieDetailsModel(
    val id: String,
    val title: String,
    val landscapeMoviePoster: String,
    val year: String,
    val rating: Double,
    val genres: List<String>,
    val duration: String,
    val cast: List<CastMemberModel>,
    val overview: String,
)

data class CastMemberModel(
    val name: String,
    val profileUrl: String?
)
