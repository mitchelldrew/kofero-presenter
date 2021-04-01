package ro.kofe.presenter

interface IProvider<T> {
    fun get(ids:List<Int>)
    fun addListener(gameListener: IProviderListener<T>)
    fun removeListener(gameListener: IProviderListener<T>)
}