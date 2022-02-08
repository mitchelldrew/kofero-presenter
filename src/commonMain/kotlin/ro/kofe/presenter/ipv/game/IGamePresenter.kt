package ro.kofe.presenter.ipv.game

interface IGamePresenter {
    fun setView(view:IGameView)
    fun showGame(id:Int)
    fun shutdown()
}