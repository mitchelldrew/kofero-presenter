package ro.kofe.presenter.home

import ro.kofe.model.Game
import ro.kofe.presenter.IImageProvider
import ro.kofe.presenter.IProvider
import ro.kofe.presenter.IProviderListener


class HomePresenter(private var gameProvider: IProvider<Game>?, private var imageProvider:IImageProvider?): IHomePresenter {
    private var view: IHomeView? = null
    private var gameListener: IProviderListener<Game>? = null
    private var imageListener: IImageProvider.Listener? = null


    private fun attachListeners(){
        gameListener = getGameListener()
        imageListener = getImageListener()
        gameProvider?.addListener(gameListener!!)
        imageProvider?.addListener(imageListener!!)
    }

    private fun getImageListener(): IImageProvider.Listener {
        return object : IImageProvider.Listener {
            override fun onReceive(url: String, imgBase64: String) { view?.display(url, imgBase64) }
            override fun onError(url: String, error: Exception) {

            }
        }
    }

    private fun getGameListener(): IProviderListener<Game> {
        return object : IProviderListener<Game> {
            override fun onReceive(ids: List<Int>, elements: List<Game>) {}
            override fun onError(ids: List<Int>, error: Exception) {}
        }
    }

    override fun setView(view: IHomeView) {
        this.view = view
        attachListeners()
    }

    override fun showGames() {
        gameProvider?.get(ArrayList())
    }

    override fun shutdown() {
        gameListener?.let{gameProvider?.removeListener(it)}
        imageListener?.let{imageProvider?.removeListener(it)}
        view = null
        gameProvider = null
        imageProvider = null
    }
}