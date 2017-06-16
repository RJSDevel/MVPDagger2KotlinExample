package pro.yagupov.model.repository.remote.entity

import com.google.gson.annotations.SerializedName

data class NewsPreview(var title: String,
                       val url: String,
                       @SerializedName("second_title")
                       var secondTitle: String?,
                       @SerializedName("published_at")
                       var publishedAt: Long,
                       var image: Images,
                       var tag: Tag
)