package ro.kofe.presenter.home

interface IHomePresenter {
    fun setView(view: IHomeView)
    fun show()
    fun shutdown()
}