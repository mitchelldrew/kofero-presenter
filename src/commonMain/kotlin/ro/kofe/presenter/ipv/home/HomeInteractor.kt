package ro.kofe.presenter.ipv.home

import ro.kofe.model.Obj
import ro.kofe.presenter.ipv.Interactor
import ro.kofe.presenter.provider.ILoggingProvider
import ro.kofe.presenter.state.IStateLogger
import ro.kofe.presenter.state.IStateReducer
import ro.kofe.model.logging.LogTag.HOME_INTERACTOR

class HomeInteractor(
    presenter: IHomePresenter,
    stateLogger: IStateLogger,
    stateReducer: IStateReducer,
    loggingProvider: ILoggingProvider
    ): IHomeInteractor, Interactor<IHomeView, IHomePresenter>(
    presenter,
    stateLogger,
    stateReducer,
    loggingProvider,
    HOME_INTERACTOR
    ) {
    override fun listPressed(obj: Obj) {
        TODO("Not yet implemented")
    }
}