package `in`.vikram.githubprs

import `in`.vikram.githubprs.data.DataRepository
import `in`.vikram.githubprs.data.DataSourceInterface
import `in`.vikram.githubprs.data.remote.ApiService
import `in`.vikram.githubprs.data.remote.AppApiHelper
import android.content.Context

object Injection {

    fun provideDataRepository(context: Context): DataSourceInterface {
        return DataRepository.getInstance(AppApiHelper(ApiService.create()))

    }

}