package pro.yagupov.mvpdagger2kotlinexample.ui.activity

import kotlinx.android.synthetic.main.news_activity.*
import pro.yagupov.model.repository.remote.entity.News
import pro.yagupov.mvpdagger2kotlinexample.CONST
import pro.yagupov.mvpdagger2kotlinexample.R
import pro.yagupov.mvpdagger2kotlinexample.presentation.presenter.news.NewsPresenter
import pro.yagupov.mvpdagger2kotlinexample.presentation.view.NewsView

/**
 * Created by developer on 07.06.17.
 */
class NewsActivity : BaseViewActivity<NewsPresenter>(), NewsView {

    override fun getLayoutId(): Int = R.layout.news_activity

    override fun doInject() {
        di().inject(this)
    }

    override fun getContentUrl(): String {
        return argument(CONST.INTENT.CONTENT_URL)
    }

    override fun showContent(news: News) {
        view.loadData(news.content.body, "text/html; charset=UTF-8", "UTF-8")
    }
}