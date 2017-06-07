package pro.yagupov.model.repository.remote

import com.google.gson.annotations.SerializedName

/**
 * Created by developer on 01.06.17.
 */
data class Images(
        @SerializedName("large_url")
        var image1: String?
)

data class Tag(
        var name: String
)

data class NewsPreview(var title: String,
                       @SerializedName("second_title")
                       var secondTitle: String?,
                       @SerializedName("published_at")
                       var publishedAt: Long,
                       var image: Images,
                       var tag: Tag
)