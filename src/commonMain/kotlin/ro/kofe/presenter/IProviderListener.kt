package ro.kofe.presenter

import ro.kofe.model.Obj

interface IProviderListener<T:Obj>{
    fun onReceive(ids:List<Int>, elements:List<T>)
    fun onError(ids:List<Int>, error:Exception)
}