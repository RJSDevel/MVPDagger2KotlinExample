package pro.yagupov.model.repository

import io.reactivex.Observable
import pro.yagupov.model.repository.remote.News
import pro.yagupov.model.repository.remote.RemoteRepository

/**
 * Created by developer on 01.06.17.
 */
class RepositoryImpl : Repository {

    internal var remote : RemoteRepository = RemoteRepository()

    override fun getNews(page: Int): Observable<List<News>> = remote.getNews(page)
}