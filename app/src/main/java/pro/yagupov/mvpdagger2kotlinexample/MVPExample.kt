package pro.yagupov.mvpdagger2kotlinexample

import android.app.Application
import pro.yagupov.model.RepositoryModule
import pro.yagupov.mvpdagger2kotlinexample.di.AppComponent
import pro.yagupov.mvpdagger2kotlinexample.di.DaggerAppComponent
import pro.yagupov.mvpdagger2kotlinexample.di.module.AppModule

/**
 * Created by developer on 30.05.17.
 */

open class MVPExample : Application() {

    companion object {
        lateinit var component: AppComponent
    }


    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .repositoryModule(RepositoryModule(this))
                .build()
        component.inject(this)
    }
}

