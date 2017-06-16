package pro.yagupov.model.repository.remote.service

import io.reactivex.Observable
import pro.yagupov.model.repository.remote.entity.Root
import pro.yagupov.model.repository.remote.internal.NewsPreviewWrapper
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

/**
 * Created by developer on 03.06.17.
 */
interface MeduzaService {

    @GET("search")
    fun getNewsPreviews(@Query("page") page: Int, @Query("chrono") chrono: String = "news", @Query("locale") locale: String = "ru", @Query("per_page") count: Int = 24): Observable<NewsPreviewWrapper>

    @GET
    fun getNews(@Url url: String): Observable<Root>
}