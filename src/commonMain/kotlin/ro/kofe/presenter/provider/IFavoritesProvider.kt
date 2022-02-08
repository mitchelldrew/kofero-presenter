package ro.kofe.presenter.provider

import ro.kofe.model.Obj
import ro.kofe.presenter.provider.IProvider

interface IFavoritesProvider: IProvider<Obj> {
    fun save(item:Obj)
    fun delete(item:Obj)
}