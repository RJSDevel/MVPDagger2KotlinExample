package pro.yagupov.model.repository

import io.reactivex.Observable
import pro.yagupov.model.repository.remote.entity.News
import pro.yagupov.model.repository.remote.entity.NewsPreview

/**
 * Created by developer on 01.06.17.
 */
interface Repository {

    fun getNewsPreviews(page: Int) : Observable<List<NewsPreview>>

    fun getNews(url: String): Observable<News>
}