package ro.kofe.presenter

import ro.kofe.model.Move

interface IMoveProvider {
    fun get(id:Int)
    fun addListener(moveListener:Listener)
    fun removeListener(moveListener:Listener)

    interface Listener{
        fun onReceive(id:Int, move:Move)
        fun onError(error:Exception)
    }
}