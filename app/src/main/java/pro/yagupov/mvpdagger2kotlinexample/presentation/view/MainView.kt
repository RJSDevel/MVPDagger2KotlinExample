package pro.yagupov.mvpdagger2kotlinexample.presentation.view

import pro.yagupov.model.repository.remote.News

/**
 * Created by developer on 01.06.17.
 */
interface MainView : BaseView {

    fun showNews(news: List<News>, isLast: Boolean)

    fun onError()
}