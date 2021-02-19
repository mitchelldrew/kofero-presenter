package ro.kofe.presenter.character

import ro.kofe.model.Move
import ro.kofe.presenter.IImageProvider
import ro.kofe.presenter.IMoveProvider

class CharacterPresenter(private val moveProvider:IMoveProvider, private val imageProvider:IImageProvider): ICharacterPresenter {
    private var view:ICharacterView? = null
    private var moveListener:IMoveProvider.Listener? = null
    private var imageListener:IImageProvider.Listener? = null

    private fun getImageListener(): IImageProvider.Listener {
        return object : IImageProvider.Listener {
            override fun onReceive(url: String, imgBase64: String) {

            }
        }
    }

    private fun getMoveListener(): IMoveProvider.Listener {
        return object : IMoveProvider.Listener {
            override fun onReceive(id: Int, move: Move) {

            }
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