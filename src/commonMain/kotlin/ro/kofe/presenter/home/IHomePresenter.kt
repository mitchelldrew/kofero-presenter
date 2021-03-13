package ro.kofe.presenter.home

interface IHomePresenter {
    fun setView(view: IHomeView)
    fun showGames()
    fun shutdown()
}