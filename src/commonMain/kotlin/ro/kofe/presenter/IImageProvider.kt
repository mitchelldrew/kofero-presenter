package ro.kofe.presenter

interface IImageProvider {
    fun get(url:String,save:Boolean)
    fun addListener(imgListener:Listener)
    fun removeListener(imgListener:Listener)

    interface Listener{
        fun onReceive(url:String, imgBase64:String)
        fun onError(url:String, error:Exception)
    }
}