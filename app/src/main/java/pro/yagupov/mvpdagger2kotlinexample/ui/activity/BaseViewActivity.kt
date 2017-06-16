package pro.yagupov.mvpdagger2kotlinexample.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pro.yagupov.mvpdagger2kotlinexample.MVPExample
import pro.yagupov.mvpdagger2kotlinexample.di.AppComponent
import pro.yagupov.mvpdagger2kotlinexample.presentation.presenter.BasePresenter
import pro.yagupov.mvpdagger2kotlinexample.presentation.view.BaseView
import javax.inject.Inject

/**
 * Created by developer on 30.05.17.
 */
abstract class BaseViewActivity<P : BasePresenter> : AppCompatActivity(), BaseView {

    @Inject
    lateinit var pr: P

    override fun show(context: Context, arguments: Bundle?) {
        val intent = Intent(context, javaClass)
        arguments.let { intent.putExtras(it) }
        context.startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        doInject()

        pr.attachView(this)

        onInit()

        pr.onCreate()

    }

    open fun onInit() {}

    @Suppress("UNCHECKED_CAST")
    protected fun <T> argument(name: String): T {
        return intent.extras[name] as T
    }

    fun pr(): P {
        return pr
    }

    fun di(): AppComponent {
        return MVPExample.component
    }

    abstract fun getLayoutId(): Int
    abstract fun doInject()
}