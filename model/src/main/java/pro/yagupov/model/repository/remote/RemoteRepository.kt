package pro.yagupov.model.repository.remote

import com.google.gson.GsonBuilder
import io.reactivex.Observable
import io.reactivex.Observable.create
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pro.yagupov.model.BuildConfig
import pro.yagupov.model.repository.remote.internal.NewsDeserializer
import pro.yagupov.model.repository.remote.internal.NewsWrapper
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
                    .registerTypeAdapter(NewsWrapper::class.java, NewsDeserializer())
                    .create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(MeduzaService::class.java)


    fun getNews(page: Int): Observable<List<News>> {
        return create {
            subscriber ->
            service.getNews(page)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { (news) ->
                        news.forEach { news ->
                            news.image?.image1?.let {
                                news.image.image1 = BuildConfig.SERVER_URL + it
                            }
                        }
                        subscriber?.onNext(news)
                    }
        }
    }
}