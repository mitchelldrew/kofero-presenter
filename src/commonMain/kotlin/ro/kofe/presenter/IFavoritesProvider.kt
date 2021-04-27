package ro.kofe.presenter

import ro.kofe.model.Obj

interface IFavoritesProvider: IProvider<Obj> {
    fun save(item:Obj,type:FavType)
    fun delete(item:Obj,type:FavType)

    enum class FavType{ GAME,CHAR,MOVE }
}