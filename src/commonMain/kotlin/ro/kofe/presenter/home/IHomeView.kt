package ro.kofe.presenter.home

import ro.kofe.model.Game
import ro.kofe.model.Obj

interface IHomeView {
    fun display(games:List<Game>)
    fun display(favorites:List<Obj>)
    fun display(url:String, imgBase64:String)
    fun error(error:Exception)
}