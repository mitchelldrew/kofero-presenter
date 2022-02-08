package ro.kofe.presenter.state

import ro.kofe.model.state.Event

interface IStateRepository {
    fun get()
    fun save(map:Map<Long, Event>)
    fun addListener(listener:Listener):Boolean
    fun removeListener(listener:Listener):Boolean

    interface Listener{
        fun onReceive(stateMap:Map<Long,Event>)
        fun onSaved(map:Map<Long,Event>, result:Boolean)
    }
}