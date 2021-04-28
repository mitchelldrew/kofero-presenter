package ro.kofe.presenter.game

import ro.kofe.model.Character
import ro.kofe.model.Game

interface IGameView {
    fun display(game:Game)
    fun display(characters:List<Character>)
    fun display(url:String, imgBase64:String)
    fun error(error:Exception)
}