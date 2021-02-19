package ro.kofe.presenter.game

interface IGamePresenter {
    fun setView(view:IGameView)
    fun show(id:Int)
    fun shutdown()
}