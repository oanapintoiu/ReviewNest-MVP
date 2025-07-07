package com.example.reviewnest_mvp.presenter

import com.example.reviewnest_mvp.model.MoviesListProvider

class MoviesPresenter : MoviesPresenterContract {
    private var view: MoviesView? = null

    override fun attachView(view: MoviesView) {
        this.view = view
    }

    override fun loadMovies() {
        val movies = MoviesListProvider().getMovies()
        view?.showMovies(movies)
    }
}
