package `in`.vikram.githubprs.data

import `in`.vikram.githubprs.data.remote.ApiHelper
import `in`.vikram.githubprs.data.remote.AppApiHelper
import `in`.vikram.githubprs.data.remote.model.responses.PullRequest
import io.reactivex.Single

class DataRepository(val apiHelper: ApiHelper) : DataSourceInterface {

    companion object {

        private var INSTANCE: DataRepository? = null

        /**
         * Returns the single instance of this class, creating it if necessary.
         */
        @JvmStatic
        fun getInstance(
            appApiHelper: AppApiHelper
        ): DataRepository {
            return INSTANCE ?: DataRepository(appApiHelper)
                .apply { INSTANCE = this }
        }

        /**
         * Used to force [getInstance] to create a new instance
         * next time it's called.
         */
        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }

    override fun fetchPRs(state: String): Single<List<PullRequest>> {
        return apiHelper.fetchPRs("square", "retrofit", state)
    }

}