package dmitry.man.task6ted

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface TedApi {

    @GET("/rolling-scopes-school/rs.android.task.6/master/data/data.json")
    suspend fun getListOfTed(): ApiData
}

object TedApiImpl {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("https://raw.githubusercontent.com")
        .build()

    private val TedService = retrofit.create(TedApi::class.java)

    suspend fun getListOfTed(): List<TedVideo> {
        return withContext(Dispatchers.IO) {
            TedService.getListOfTed()
                .channel.item
                .map { result ->
                    TedVideo(
                        result.title?.substringAfter('|')
                            ?.substring(1),
                        result.image?.imageUrl,
                        result.duration.durationText,
                        result.title?.substringBefore('|'),
                        result.descriptionFull
                    )
                }
        }
    }
}