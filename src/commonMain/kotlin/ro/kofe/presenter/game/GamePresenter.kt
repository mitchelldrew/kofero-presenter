package ro.kofe.presenter.game

import ro.kofe.model.Character
import ro.kofe.model.Game
import ro.kofe.presenter.IFreezer
import ro.kofe.presenter.IImageProvider
import ro.kofe.presenter.IProvider
import ro.kofe.presenter.IProviderListener

class GamePresenter(private var freezer: IFreezer?, private var characterProvider: IProvider<Character>?, private var gameProvider: IProvider<Game>?, private var imageProvider:IImageProvider?): IGamePresenter {
    private var view:IGameView? = null
    private var gameListener:IProviderListener<Game>? = null
    private var characterListener:IProviderListener<Character>? = null
    private var imageListener:IImageProvider.Listener? = null


    private fun getGameListener(): IProviderListener<Game>{
        return object : IProviderListener<Game> {
            override fun onReceive(ids: List<Int>, elements: List<Game>) {
                freezer?.freeze(elements)
                view?.display(elements[0])
                characterProvider?.get(elements[0].characterIds)
            }
            override fun onError(ids: List<Int>, error: Exception) {
                view?.error(error)
            }
        }
    }

    private fun getCharacterListener(): IProviderListener<Character> {
        return object : IProviderListener<Character>{
            override fun onReceive(ids: List<Int>, elements: List<Character>) {
                freezer?.freeze(elements)
                view?.display(elements)
                for(char in elements){
                    imageProvider?.get(char.iconUrl)
                }
            }
            override fun onError(ids: List<Int>, error: Exception) {
                view?.error(error)
            }
        }
    }

    private fun getImageListener(): IImageProvider.Listener {
        return object : IImageProvider.Listener {
            override fun onReceive(url: String, imgBase64: String) {
                view?.display(url,imgBase64)
            }
            override fun onError(url: String, error: Exception) {
                view?.error(error)
            }
        }
    }

    private fun attachListeners(){
        characterListener = getCharacterListener()
        imageListener = getImageListener()
        gameListener = getGameListener()
        freezer?.freeze(characterListener!!)
        freezer?.freeze(gameListener!!)
        freezer?.freeze(imageListener!!)
        gameProvider?.addListener(gameListener!!)
        characterProvider?.addListener(characterListener!!)
        imageProvider?.addListener(imageListener!!)
    }

    override fun setView(view: IGameView) {
        this.view = view
        attachListeners()
    }

    override fun showGame(id: Int) {
        var list = ArrayList<Int>()
        list.add(id)
        gameProvider?.get(list)
    }

    override fun shutdown() {
        gameListener?.let{gameProvider?.removeListener(it)}
        imageListener?.let{imageProvider?.removeListener(it)}
        characterListener?.let{characterProvider?.removeListener(it)}
        view = null
        gameProvider = null
        imageProvider = null
        characterProvider = null
    }
}