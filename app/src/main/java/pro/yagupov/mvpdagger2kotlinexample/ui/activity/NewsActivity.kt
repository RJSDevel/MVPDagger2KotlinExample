package pro.yagupov.mvpdagger2kotlinexample.ui.activity

import pro.yagupov.mvpdagger2kotlinexample.R
import pro.yagupov.mvpdagger2kotlinexample.presentation.presenter.news.NewsPresenter

/**
 * Created by developer on 07.06.17.
 */
class NewsActivity : BaseViewActivity<NewsPresenter>() {

    override fun getLayoutId(): Int = R.layout.news_activity

    override fun doInject() {
        di().inject(this)
    }

    override fun onInit() {
    }

}