package ro.kofe.presenter.ipv.character

import ro.kofe.model.Character
import ro.kofe.model.Move

interface ICharacterView {
    fun display(character:Character)
    fun display(moves:List<Move>)
    fun display(url:String, imgBase64:String)
    fun error(error:Exception)
}