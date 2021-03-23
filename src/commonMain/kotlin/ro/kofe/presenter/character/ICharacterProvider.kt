package ro.kofe.presenter.character

import ro.kofe.model.Character

interface ICharacterProvider {
    fun get(ids:List<Int>)
    fun addListener(charListener: Listener)
    fun removeListener(charListener: Listener)

    interface Listener{
        fun onReceive(ids:List<Int>, chars:List<Character>)
        fun onError(id:Int, Error:Exception)
    }
}