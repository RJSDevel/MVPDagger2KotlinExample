package pro.yagupov.model.repository

import io.reactivex.Observable
import pro.yagupov.model.repository.remote.entity.NewsPreview
import pro.yagupov.model.repository.remote.RemoteRepository
import pro.yagupov.model.repository.remote.entity.News

/**
 * Created by developer on 01.06.17.
 */
class RepositoryImpl : Repository {

    internal var remote : RemoteRepository = RemoteRepository()

    override fun getNewsPreviews(page: Int): Observable<List<NewsPreview>> =
            remote.getNewsPreviews(page)
                    .map { it.filter { preview -> preview.tag.name != "игры" } }

    override fun getNews(url: String): Observable<News> =
            remote.getNews(url)
}