package ro.kofe.presenter.game

import ro.kofe.model.Character
import ro.kofe.presenter.IImageProvider
import ro.kofe.presenter.character.ICharacterProvider

class GamePresenter(private val characterProvider: ICharacterProvider, private val imageProvider:IImageProvider): IGamePresenter {
    private var view:IGameView? = null
    private var characterListener:ICharacterProvider.Listener? = null
    private var imageListener:IImageProvider.Listener? = null


    private fun getCharacterListener(): ICharacterProvider.Listener {
        return object : ICharacterProvider.Listener {
            override fun onReceive(id: Int, char: Character) {
            }
        }
    }

    private fun getImageListener(): IImageProvider.Listener {
        return object : IImageProvider.Listener {
            override fun onReceive(url: String, imgBase64: String) {
            }
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

    override fun show(id: Int) {
        TODO("Not yet implemented")
    }

    override fun shutdown() {
        TODO("Not yet implemented")
    }
}