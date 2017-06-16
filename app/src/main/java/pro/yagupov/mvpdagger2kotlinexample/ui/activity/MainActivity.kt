package pro.yagupov.mvpdagger2kotlinexample.ui.activity

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import pro.yagupov.model.repository.remote.entity.NewsPreview
import pro.yagupov.mvpdagger2kotlinexample.R
import pro.yagupov.mvpdagger2kotlinexample.adapter.NewsAdapter
import pro.yagupov.mvpdagger2kotlinexample.presentation.presenter.main.MainViewPresenter
import pro.yagupov.mvpdagger2kotlinexample.presentation.view.MainView


class MainActivity : BaseViewActivity<MainViewPresenter>(), MainView, SwipeRefreshLayout.OnRefreshListener {

    private val adapter: NewsAdapter = NewsAdapter()

    private var isLoading = false
    private var isLastPage = false


    override fun getLayoutId(): Int = R.layout.activity_main

    override fun doInject() {
        di().inject(this)
    }

    override fun onInit() {
        initActionBar()
        initList()
        onRefresh()
    }

    private fun initActionBar() {
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setIcon(R.drawable.logo)
        supportActionBar!!.title = null
    }

    private fun initList() {
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter
        list.addOnScrollListener(onRecyclerScrollListener)
        refresh.setOnRefreshListener(this)
        refresh.setColorSchemeColors(R.color.colorAccent)
        refresh.isRefreshing = true
    }

    override fun onRefresh() {
        adapter.clean()
        isLoading = true
        pr().loadFirstPage()
    }

    private val onRecyclerScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val visibleItemCount = list.layoutManager.childCount
            val totalItemCount = list.layoutManager.itemCount
            val firstVisibleItemPosition = (list.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
            if (!isLoading && !isLastPage) {
                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount / 1.2f
                        && firstVisibleItemPosition >= 0) {
                    isLoading = true
                    pr().loadNextPage()
                }
            }
        }
    }

    override fun showNews(news: List<NewsPreview>, isLast: Boolean) {
        isLoading = false
        isLastPage = isLast
        refresh.isRefreshing = false
        adapter.add(news)
    }

    override fun onError() {
        isLoading = false
        refresh.isRefreshing = false
    }
}
