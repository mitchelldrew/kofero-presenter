package ro.kofe.presenter

import ro.kofe.model.Obj

interface IProvider<T:Obj> {
    fun get(ids:List<Int>)
    fun addListener(listener: IProviderListener<T>)
    fun removeListener(listener: IProviderListener<T>)
}