package pro.yagupov.mvpdagger2kotlinexample.presentation.presenter.main

import pro.yagupov.mvpdagger2kotlinexample.presentation.presenter.BasePresenterImpl
import pro.yagupov.mvpdagger2kotlinexample.presentation.view.MainView

/**
 * Created by developer on 30.05.17.
 */
class MainViewPresenterImpl : BasePresenterImpl<MainView>(), MainViewPresenter {

    private val PAGE_COUNT = 9

    private var page: Int = 1


    override fun doInject() {
        di().inject(this)
    }

    override fun loadFirstPage() {
        page = 0
        repo().getNewsPreviews(page).subscribe {
            view().showNews(it, false)
        }
    }

    override fun loadNextPage() {
        repo().getNewsPreviews(++page).subscribe {
            view().showNews(it, page > PAGE_COUNT)
        }
    }
}