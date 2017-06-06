package pro.yagupov.mvpdagger2kotlinexample.presentation.presenter

/**
 * Created by developer on 30.05.17.
 */
interface BasePresenter {

    fun <T> attachView(attachView: T)

    fun onCreate()
}