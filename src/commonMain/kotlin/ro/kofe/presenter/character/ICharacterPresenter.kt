package ro.kofe.presenter.character

interface ICharacterPresenter {
    fun setView(view:ICharacterView)
    fun get(id:Int)
}