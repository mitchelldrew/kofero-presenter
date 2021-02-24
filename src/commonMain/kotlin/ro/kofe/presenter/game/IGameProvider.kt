package ro.kofe.presenter.game

import ro.kofe.model.Game

interface IGameProvider {
    fun get()
    fun get(id:Int)
    fun addListener(gameListener: Listener)
    fun removeListener(gameListener: Listener)

    interface Listener {
        fun onReceive(games:List<Game>)
        fun onReceive(id:Int, game:Game)
        fun onError(error:Exception)
    }
}