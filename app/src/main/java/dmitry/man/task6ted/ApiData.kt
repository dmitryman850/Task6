package dmitry.man.task6ted

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiData(
    @Json(name = "channel") val channel: Channel
)

@JsonClass(generateAdapter = true)
data class Channel(
    @Json(name = "item") val item: List<Item>
)

@JsonClass(generateAdapter = true)
data class Item(
    @Json(name = "title") val title: String?,
    @Json(name = "description") val descriptionFull: String,
    @Json(name = "image") val image: Image?,
    @Json(name = "duration") val duration: DurationText
)

@JsonClass(generateAdapter = true)
data class DurationText(
    @Json(name = "text") val durationText: String?
)

@JsonClass(generateAdapter = true)
data class Image(
    @Json(name = "url") val imageUrl: String?
)
