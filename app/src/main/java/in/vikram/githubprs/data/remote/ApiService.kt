package `in`.vikram.githubprs.data.remote

import `in`.vikram.githubprs.BuildConfig
import `in`.vikram.githubprs.data.remote.model.responses.PullRequest
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface ApiService {


    companion object Factory {


        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()


        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }

    /****************** RELATED TO OTP ***********************/

    @GET(EndPoints.GET_PR)
    fun fetchPRs(@Path("owner") owner: String, @Path("repo") repo: String, @Query("state") state : String): Single<List<PullRequest>>


}