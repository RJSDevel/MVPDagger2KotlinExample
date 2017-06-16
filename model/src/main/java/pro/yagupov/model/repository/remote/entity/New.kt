package pro.yagupov.model.repository.remote.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by developer on 16.06.17.
 */
data class Content(
        var body: String
)

data class Source(
        var name: String
)

data class News(
        var title: String,
        var source: Source,
        var image: Images,
        var content: Content,
        var tag: Tag,
        @SerializedName("published_at")
        var publishedAt: Long
)

data class Root(
        @SerializedName("root")
        var news: News
)