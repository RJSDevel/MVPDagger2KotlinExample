package pro.yagupov.mvpdagger2kotlinexample.presentation.view

import pro.yagupov.model.repository.remote.entity.News

/**
 * Created by developer on 07.06.17.
 */
interface NewsView : BaseView {
    fun getContentUrl(): String
    fun showContent(news: News)
}