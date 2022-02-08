package ro.kofe.presenter.ipv.home

interface IHomePresenter {
    fun setView(view: IHomeView)
    fun showGames()
    fun shutdown()
}