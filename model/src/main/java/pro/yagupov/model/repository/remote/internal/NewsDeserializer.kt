package pro.yagupov.model.repository.remote.internal

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import pro.yagupov.model.repository.remote.NewsPreview
import java.lang.reflect.Type

/**
 * Created by developer on 03.06.17.
 */
class NewsDeserializer : JsonDeserializer<NewsWrapper> {

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): NewsWrapper {

        val jsonObject = json?.asJsonObject
        val documents = jsonObject?.get("documents")?.asJsonObject
        val news = mutableListOf<NewsPreview>()
        val gson = Gson()

        jsonObject?.get("collection")?.asJsonArray!!
                .mapTo(news) { gson.fromJson(documents!![it.asString], NewsPreview::class.java) }

        return NewsWrapper(news)
    }

}