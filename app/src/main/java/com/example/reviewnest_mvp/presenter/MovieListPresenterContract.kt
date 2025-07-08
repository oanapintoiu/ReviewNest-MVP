package com.example.reviewnest_mvp.presenter

import com.example.reviewnest_mvp.model.MovieListItemModel

//this defines what the UI must show/provide
//Declares functions for attaching the UI and triggering the load of movie data.
interface MovieListView {
    fun showMovieList(movies: List<MovieListItemModel>)
}

interface MoviesListPresenterContract {
    fun attachView(view: MovieListView)
    fun loadMovies()

}
