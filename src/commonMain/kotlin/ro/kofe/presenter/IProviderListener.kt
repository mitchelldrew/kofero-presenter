package ro.kofe.presenter

interface IProviderListener<T>{
    fun onReceive(ids:List<Int>, elements:List<T>)
    fun onError(ids:List<Int>, error:Exception)
}