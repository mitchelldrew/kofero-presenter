package ro.kofe.presenter.root

import ro.kofe.presenter.IProvider
import ro.kofe.model.Game
import ro.kofe.presenter.IProviderListener

class RootPresenter(private val gameProvider: IProvider<Game>): IRootPresenter {
    private var view:IRootView? = null
    private var listener: IProviderListener<Game>? = null

    private fun getGameListener(): IProviderListener<Game> {
        return object : IProviderListener<Game> {
            override fun onReceive(ids: List<Int>, elements: List<Game>) {
                print("#########")
                print(elements)
                view?.error(Exception(elements.toString()))
            }

            override fun onError(ids: List<Int>, error: Exception) {
                print("@@@@@@@@@")
            }

        }
    }

    override fun setView(rootView: IRootView) {
        this.view = rootView
        view?.error(Exception("hello world"))
        listener = getGameListener()
        gameProvider.addListener(listener!!)
        gameProvider.get(ArrayList<Int>().apply { add(1);add(2)})
    }

    override fun shutdown() {
        view = null
        gameProvider.removeListener(listener!!)
    }
}