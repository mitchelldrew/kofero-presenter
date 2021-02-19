package ro.kofe.presenter.home

import ro.kofe.model.Game

interface IHomeView {
    fun display(games:List<Game>)
    fun display(url:String, imgBase64:String)
}