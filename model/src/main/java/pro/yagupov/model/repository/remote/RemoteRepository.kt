package pro.yagupov.model.repository.remote

import com.google.gson.GsonBuilder
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pro.yagupov.model.BuildConfig
import pro.yagupov.model.repository.remote.entity.News
import pro.yagupov.model.repository.remote.entity.NewsPreview
import pro.yagupov.model.repository.remote.internal.NewsPreviewDeserializer
import pro.yagupov.model.repository.remote.internal.NewsPreviewWrapper
import pro.yagupov.model.repository.remote.service.MeduzaService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by developer on 01.06.17.
 */
class RemoteRepository {

    private val API_URL: String = BuildConfig.SERVER_URL + "/api/v3/"

    private var service: MeduzaService = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder()
                    .registerTypeAdapter(NewsPreviewWrapper::class.java, NewsPreviewDeserializer())
                    .create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(MeduzaService::class.java)


    fun getNewsPreviews(page: Int): Observable<List<NewsPreview>> = service.getNewsPreviews(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext({
                it.news.forEach { news ->
                    news.image?.image1 = BuildConfig.SERVER_URL + news.image.image1
                }
            })
            .flatMap({ (news) -> Observable.just(news) })

    fun getNews(url: String): Observable<News> =
            service.getNews(url)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .flatMap { (news) -> Observable.just(news) }
}