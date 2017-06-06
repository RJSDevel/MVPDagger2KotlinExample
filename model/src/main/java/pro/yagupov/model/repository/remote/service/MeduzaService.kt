package pro.yagupov.model.repository.remote.service

import io.reactivex.Observable
import pro.yagupov.model.repository.remote.internal.NewsWrapper
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by developer on 03.06.17.
 */
interface MeduzaService {

    @GET("search")
    fun getNews(@Query("page") page: Int, @Query("chrono") chrono : String = "news", @Query("locale") locale : String = "ru", @Query("per_page") count: Int = 24): Observable<NewsWrapper>
}