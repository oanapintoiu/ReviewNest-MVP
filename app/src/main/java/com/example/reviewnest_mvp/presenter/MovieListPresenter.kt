package com.example.reviewnest_mvp.presenter

import com.example.reviewnest_mvp.network.api.TMDbApiProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//declare a function that the Presenter can call to update the UI with a list of movies
class MovieListPresenter(
    private val provider: TMDbApiProvider
) : MoviesListPresenterContract {
    private var view: MovieListView? = null

    override fun attachView(view: MovieListView) {
        this.view = view
    }

    override fun loadMovies() {
        CoroutineScope(Dispatchers.Main).launch {
            val movies = provider.getMovies()
            view?.showMovieList(movies)
        }
    }
}
