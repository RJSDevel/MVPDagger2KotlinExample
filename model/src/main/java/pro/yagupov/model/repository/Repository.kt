package pro.yagupov.model.repository

import io.reactivex.Observable
import pro.yagupov.model.repository.remote.NewsPreview

/**
 * Created by developer on 01.06.17.
 */
interface Repository {

    fun getNews(page: Int) : Observable<List<NewsPreview>>

}