package pro.yagupov.mvpdagger2kotlinexample.presentation.presenter

import pro.yagupov.model.repository.Repository
import pro.yagupov.mvpdagger2kotlinexample.MVPExample
import pro.yagupov.mvpdagger2kotlinexample.di.AppComponent
import pro.yagupov.mvpdagger2kotlinexample.presentation.view.BaseView
import javax.inject.Inject

/**
 * Created by developer on 30.05.17.
 */

abstract class BasePresenterImpl<out V : BaseView> : BasePresenter {

    @Inject
    lateinit var rp: Repository

    private lateinit var view: V

    @Suppress("UNCHECKED_CAST")
    override fun <T> attachView(attachView: T) {
        view = attachView as V
        doInject()
    }

    open fun doInject() {}

    override fun onCreate() {
    }

    fun view(): V = view

    fun repo(): Repository = rp

    fun di(): AppComponent = MVPExample.component
}