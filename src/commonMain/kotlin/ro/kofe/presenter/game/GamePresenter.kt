package ro.kofe.presenter.game

import ro.kofe.model.Character
import ro.kofe.model.Game
import ro.kofe.presenter.IImageProvider
import ro.kofe.presenter.IProvider
import ro.kofe.presenter.IProviderListener

class GamePresenter(private val characterProvider: IProvider<Character>, private val gameProvider: IProvider<Game>, private val imageProvider:IImageProvider): IGamePresenter {
    private var view:IGameView? = null
    private var gameListener:IProviderListener<Game>? = null
    private var characterListener:IProviderListener<Character>? = null
    private var imageListener:IImageProvider.Listener? = null


    private fun getCharacterListener(): IProviderListener<Character> {
        return object : IProviderListener<Character>{
            override fun onReceive(ids: List<Int>, elements: List<Character>) {}
            override fun onError(ids: List<Int>, error: Exception) {}
        }
    }

    private fun getImageListener(): IImageProvider.Listener {
        return object : IImageProvider.Listener {
            override fun onReceive(url: String, imgBase64: String) {}
            override fun onError(url: String, error: Exception) {}
        }
    }

    private fun attachListeners(){
        characterListener = getCharacterListener()
        imageListener = getImageListener()
        characterProvider.addListener(characterListener!!)
        imageProvider.addListener(imageListener!!)
    }

    override fun setView(view: IGameView) {
        this.view = view
        attachListeners()
    }

    override fun showGame(id: Int) {
    }

    override fun shutdown() {
    }
}