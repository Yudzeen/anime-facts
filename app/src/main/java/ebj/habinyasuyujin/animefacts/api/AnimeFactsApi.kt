package ebj.habinyasuyujin.animefacts.api

import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface AnimeFactsApi {

    @GET(".")
    fun getAnimeList(): Single<AnimeFactsListResponse>

    companion object {
        private const val BASE_URL = "https://anime-facts-rest-api.herokuapp.com/api/v1/"

        fun create(): AnimeFactsApi {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(AnimeFactsApi::class.java)
        }
    }

}