package ro.kofe.presenter.state

import ro.kofe.model.state.Event

interface IStateLogger {
    fun logState(unixTime: Long, event: Event): Boolean
    fun getStateMap(): Map<Long, Event>
}