package ro.kofe.presenter.character

import ro.kofe.model.Character
import ro.kofe.model.Move

interface ICharacterView {
    fun display(character:Character)
    fun display(moves:List<Move>)
}