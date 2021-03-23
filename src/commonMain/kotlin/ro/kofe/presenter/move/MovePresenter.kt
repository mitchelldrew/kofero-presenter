package ro.kofe.presenter.move

import ro.kofe.presenter.IImageProvider
import ro.kofe.presenter.character.ICharacterProvider
import ro.kofe.presenter.game.IGameProvider

class MovePresenter(private val moveProvider:IMoveProvider, private val charProvider:ICharacterProvider, private val gameProvider:IGameProvider, private val imageProvider:IImageProvider): IMovePresenter {
}