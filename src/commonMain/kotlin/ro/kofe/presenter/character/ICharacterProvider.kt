package ro.kofe.presenter.character

import ro.kofe.model.Character

interface ICharacterProvider {
    fun get(id:Int)
    fun addListener(charListener: Listener)
    fun removeListener(charListener: Listener)

    interface Listener{
        fun onReceive(id:Int, char:Character)
        fun onError(id:Int, Error:Exception)
    }
}