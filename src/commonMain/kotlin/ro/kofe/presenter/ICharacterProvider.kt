package ro.kofe.presenter

import ro.kofe.model.Character

interface ICharacterProvider {
    fun get(id:Int)
    fun get(charName:String,gameName:String)

    interface Listener{
        fun onReceive(id:Int, char:Character)
    }
}