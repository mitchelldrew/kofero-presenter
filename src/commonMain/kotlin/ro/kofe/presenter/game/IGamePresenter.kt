package ro.kofe.presenter.game

interface IGamePresenter {
    fun setView(view:IGameView)
    fun showGame(id:Int)
    fun shutdown()
}