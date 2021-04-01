package ro.kofe.presenter.character

import ro.kofe.model.Move
import ro.kofe.presenter.IImageProvider
import ro.kofe.presenter.IProvider
import ro.kofe.presenter.IProviderListener

class CharacterPresenter(private val moveProvider: IProvider<Move>, private val imageProvider:IImageProvider): ICharacterPresenter {
    private var view:ICharacterView? = null
    private var moveListener: IProviderListener<Move>? = null
    private var imageListener:IImageProvider.Listener? = null

    private fun getImageListener(): IImageProvider.Listener {
        return object : IImageProvider.Listener {
            override fun onReceive(url: String, imgBase64: String) {

            }

            override fun onError(url: String, error: Exception) {

            }
        }
    }

    private fun getMoveListener(): IProviderListener<Move> {
        return object : IProviderListener<Move> {
            override fun onReceive(ids: List<Int>, elements: List<Move>) {}
            override fun onError(ids: List<Int>, error: Exception) {}
        }
    }

    private fun attachListeners(){
        imageListener = getImageListener()
        moveListener = getMoveListener()
        imageProvider.addListener(imageListener!!)
        moveProvider.addListener(moveListener!!)
    }

    override fun setView(view: ICharacterView) {
        this.view = view
        attachListeners()
    }

    override fun get(id: Int) {
    }
}