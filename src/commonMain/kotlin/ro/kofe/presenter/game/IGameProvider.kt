package ro.kofe.presenter.game

import ro.kofe.model.Game

interface IGameProvider {
    fun get(id:Int)
    fun get(ids:List<Int>)
    fun addListener(gameListener: Listener)
    fun removeListener(gameListener: Listener)

    interface Listener {
        fun onReceive(ids:List<Int>, games:List<Game>)
        fun onReceive(id:Int, game:Game)
        fun onError(id:Int, error:Exception)
    }
}