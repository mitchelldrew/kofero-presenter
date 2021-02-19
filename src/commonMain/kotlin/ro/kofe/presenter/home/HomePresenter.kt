package ro.kofe.presenter.home

import ro.kofe.model.Game
import ro.kofe.presenter.game.IGameProvider


class HomePresenter(private val gameProvider: IGameProvider): IHomePresenter {
    private var view: IHomeView? = null
    private var gameListener: IGameProvider.Listener? = null


    private fun attachListeners(){
        gameListener = getGameListener()
        gameProvider.addListener(gameListener!!)
    }

    private fun getGameListener(): IGameProvider.Listener {
        return object : IGameProvider.Listener {
            override fun onReceive(games: List<Game>) {
            }

            override fun onReceive(id: Int, game: Game) {
            }

        }
    }

    override fun setView(view: IHomeView) {
        this.view = view
        attachListeners()
    }

    override fun show() {
        gameProvider.get()
    }

    override fun shutdown() {

    }

}