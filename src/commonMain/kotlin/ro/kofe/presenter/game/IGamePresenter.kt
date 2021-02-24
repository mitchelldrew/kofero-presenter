package ro.kofe.presenter.game

interface IGamePresenter {
    fun setView(view:IGameView)
    fun showGames()
    fun showGame(id:Int)
    fun shutdown()
}