package ro.kofe.presenter.ipv.root

interface IRootPresenter {
    fun setView(rootView:IRootView)
    fun shutdown()
}