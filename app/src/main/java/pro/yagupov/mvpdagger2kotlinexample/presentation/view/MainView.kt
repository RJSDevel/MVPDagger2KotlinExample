package pro.yagupov.mvpdagger2kotlinexample.presentation.view

import pro.yagupov.model.repository.remote.entity.NewsPreview

/**
 * Created by developer on 01.06.17.
 */
interface MainView : BaseView {

    fun showNews(news: List<NewsPreview>, isLast: Boolean)

    fun onError()
}