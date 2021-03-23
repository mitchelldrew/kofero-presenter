package ro.kofe.presenter.move

import ro.kofe.model.Move

interface IMoveProvider {
    fun get(id:Int)
    fun get(ids:List<Int>)
    fun addListener(moveListener: Listener)
    fun removeListener(moveListener: Listener)

    interface Listener{
        fun onReceive(ids:List<Int>, moves:List<Move>)
        fun onError(error:Exception)
    }
}