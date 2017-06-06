package pro.yagupov.mvpdagger2kotlinexample.di.module

import dagger.Module
import dagger.Provides
import pro.yagupov.mvpdagger2kotlinexample.presentation.presenter.main.MainViewPresenter
import pro.yagupov.mvpdagger2kotlinexample.presentation.presenter.main.MainViewPresenterImpl

/**
 * Created by developer on 30.05.17.
 */
@Module
class PresenterModule {

    @Provides
    fun providesMainViewPresenter() : MainViewPresenter = MainViewPresenterImpl()
}