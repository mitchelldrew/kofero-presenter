package ro.kofe.presenter.ipv.home

import ro.kofe.model.Obj
import ro.kofe.presenter.ipv.IInteractor

interface IHomeInteractor: IInteractor<IHomeView> {
    fun listPressed(obj: Obj)
}