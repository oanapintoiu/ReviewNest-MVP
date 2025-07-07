package com.example.reviewnest_mvp.model

class MoviesListProvider {
    fun getMovies() : List<MoviesModel> = listOf(
        MoviesModel(
            id = "1",
            title = "Battlestar Galactica: The plan",
            posterUrl = "https://image.tmdb.org/t/p/original/snSFUEA5ftPfrXVb0xphitD2VrP.jpg"
        ),
        MoviesModel(
            id = "2",
            title = "Interstellar",
            posterUrl = "https://image.tmdb.org/t/p/w342/rAiYTfKGqDCRIIqo664sY9XZIvQ.jpg"
        ),
        MoviesModel(
            id = "3",
            title = "The Dark Knight",
            posterUrl = "https://image.tmdb.org/t/p/original/enNubozHn9pXi0ycTVYUWfpHZm.jpg"
        ),
        MoviesModel(
            id = "4",
            title = "Avatar: Creating the World of Pandora",
            posterUrl = "https://image.tmdb.org/t/p/original/uEwGFGtao9YG2JolmdvtHLLVbA9.jpg"
        ),
        MoviesModel(
            id = "5",
            title = "Dune: Part Two",
            posterUrl = "https://image.tmdb.org/t/p/original/jYEW5xZkZk2WTrdbMGAPFuBqbDc.jpg"
        )
    )
}
