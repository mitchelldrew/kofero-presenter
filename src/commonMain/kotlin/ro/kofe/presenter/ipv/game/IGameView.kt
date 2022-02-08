package ro.kofe.presenter.ipv.game

import ro.kofe.model.Character
import ro.kofe.model.Game
import ro.kofe.presenter.ipv.IView

interface IGameView: IView {
    fun display(game:Game)
    fun display(characters:List<Character>)
    fun display(url:String, imgBase64:String)
}