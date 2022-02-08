package ro.kofe.presenter.ipv.move

import ro.kofe.presenter.provider.IImageProvider
import ro.kofe.presenter.provider.IProvider
import ro.kofe.model.Move
import ro.kofe.model.Game
import ro.kofe.model.Character

class MovePresenter(private val moveProvider: IProvider<Move>, private val charProvider: IProvider<Character>, private val gameProvider: IProvider<Game>, private val imageProvider: IImageProvider): IMovePresenter {
}