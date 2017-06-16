package pro.yagupov.model.repository.remote.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by developer on 01.06.17.
 */
data class Images(
        @SerializedName("large_url")
        var image1: String?
)