package pro.yagupov.mvpdagger2kotlinexample.di

import dagger.Component
import pro.yagupov.model.RepositoryModule
import pro.yagupov.mvpdagger2kotlinexample.MVPExample
import pro.yagupov.mvpdagger2kotlinexample.di.module.AppModule
import pro.yagupov.mvpdagger2kotlinexample.di.module.PresenterModule
import pro.yagupov.mvpdagger2kotlinexample.presentation.presenter.main.MainViewPresenterImpl
import pro.yagupov.mvpdagger2kotlinexample.ui.activity.MainActivity
import pro.yagupov.mvpdagger2kotlinexample.ui.activity.NewsActivity
import javax.inject.Singleton

/**
 * Created by developer on 30.05.17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, PresenterModule::class, RepositoryModule::class))
interface AppComponent {

    fun inject(app: MVPExample)
    fun inject(activity: MainActivity)
    fun inject(presenter: MainViewPresenterImpl)
    fun inject(activity: NewsActivity)
}