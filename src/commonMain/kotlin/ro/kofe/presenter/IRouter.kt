package ro.kofe.presenter

import ro.kofe.model.state.ViewTag

interface IRouter {
    fun routeTo(view:ViewTag): Boolean
}