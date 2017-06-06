package pro.yagupov.mvpdagger2kotlinexample.di.module

import dagger.Module
import dagger.Provides
import pro.yagupov.mvpdagger2kotlinexample.MVPExample
import javax.inject.Singleton

/**
 * Created by developer on 30.05.17.
 */
@Module
class AppModule(val app : MVPExample) {

    @Provides
    @Singleton
    fun context() = app.applicationContext
}