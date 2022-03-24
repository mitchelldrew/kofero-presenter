package ro.kofe.presenter.ipv.game

import ro.kofe.model.Character
import ro.kofe.model.Event
import ro.kofe.presenter.IRouter
import ro.kofe.presenter.ipv.Interactor
import ro.kofe.model.logging.LogTag.GAME_INTERACTOR
import ro.kofe.presenter.provider.ILoggingProvider
import ro.kofe.presenter.state.IStateLogger
import ro.kofe.presenter.state.IStateReducer

class GameInteractor(
    presenter: IGamePresenter,
    stateLogger: IStateLogger,
    stateReducer: IStateReducer,
    loggingProvider: ILoggingProvider,
    router: IRouter
): IGameInteractor,
    Interactor<IGameView, IGamePresenter>(
        presenter,
        stateLogger,
        stateReducer,
        router,
        loggingProvider,
        GAME_INTERACTOR
) {

    override fun viewResumed() {
        super.viewResumed()
        val stateMap = stateLogger?.getStateMap()
        val requestsFromHome = stateMap?.entries?.filter { it.value.view == Event.ViewTag.HOME_VIEW && it.value.value == Event.Value.ROUTING_REQUEST }
        requestsFromHome?.last()?.value?.extras
    }

    override fun charPressed(char: Character) {
        TODO("Not yet implemented")
    }

}