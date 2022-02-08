package ro.kofe.presenter.ipv.character

interface ICharacterPresenter {
    fun setView(view:ICharacterView)
    fun get(id:Int)
}