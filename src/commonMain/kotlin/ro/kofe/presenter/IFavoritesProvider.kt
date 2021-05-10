package ro.kofe.presenter

import ro.kofe.model.Obj

interface IFavoritesProvider: IProvider<Obj> {
    fun save(item:Obj)
    fun delete(item:Obj)
}