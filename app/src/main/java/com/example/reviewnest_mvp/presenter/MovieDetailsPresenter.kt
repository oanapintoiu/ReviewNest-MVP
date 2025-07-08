package com.example.reviewnest_mvp.presenter

import com.example.reviewnest_mvp.network.api.TMDbApiProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailsPresenter(
    private val provider: TMDbApiProvider
) : MovieDetailsPresenterContract {

    private var view: MovieDetailsView? = null

    override fun attachView(view: MovieDetailsView) {
        this.view = view
    }

    override fun loadMovieDetails(movieId: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            val details = provider.getMovieDetails(movieId)
            view?.showMovieDetails(details)
        }
    }
}
