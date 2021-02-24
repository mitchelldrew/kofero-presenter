package ro.kofe.presenter.home

import ro.kofe.model.Game
import ro.kofe.presenter.IImageProvider
import ro.kofe.presenter.game.IGameProvider


class HomePresenter(private var gameProvider: IGameProvider?, private var imageProvider:IImageProvider?): IHomePresenter {
    private var view: IHomeView? = null
    private var gameListener: IGameProvider.Listener? = null
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

    private fun getGameListener(): IGameProvider.Listener {
        return object : IGameProvider.Listener {
            override fun onReceive(games: List<Game>) { view?.display(games) }
            override fun onReceive(id: Int, game: Game) {}
            override fun onError(error: Exception) {

            }
        }
    }

    override fun setView(view: IHomeView) {
        this.view = view
        attachListeners()
    }

    override fun show() {
        gameProvider?.get()
    }

    override fun shutdown() {
        gameListener?.let{gameProvider?.removeListener(it)}
        imageListener?.let{imageProvider?.removeListener(it)}
        view = null
        gameProvider = null
        imageProvider = null
    }
}