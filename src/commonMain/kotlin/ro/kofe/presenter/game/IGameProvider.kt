package ro.kofe.presenter.game

import ro.kofe.model.Game

interface IGameProvider {
    fun get(ids:List<Int>)
    fun addListener(gameListener: Listener)
    fun removeListener(gameListener: Listener)

    interface Listener {
        fun onReceive(ids:List<Int>, games:List<Game>)
        fun onError(id:Int, error:Exception)
    }
}