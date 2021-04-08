package ro.kofe.presenter.root

interface IRootPresenter {
    fun setView(rootView:IRootView)
    fun shutdown()
}