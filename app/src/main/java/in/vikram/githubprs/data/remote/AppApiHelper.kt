package `in`.vikram.githubprs.data.remote

import `in`.vikram.githubprs.data.remote.model.responses.PullRequest
import androidx.annotation.VisibleForTesting
import io.reactivex.Single

class AppApiHelper(val apiService: ApiService) : ApiHelper {

    companion object {
        private var INSTANCE: AppApiHelper? = null

        @JvmStatic
        fun getInstance(apiService: ApiService): AppApiHelper {
            if (INSTANCE == null) {
                synchronized(AppApiHelper::javaClass) {
                    INSTANCE = AppApiHelper(apiService)
                }
            }
            return INSTANCE!!
        }

        @VisibleForTesting
        fun clearInstance() {
            INSTANCE = null
        }
    }

    override fun fetchPRs(owner : String, repo : String, state: String): Single<List<PullRequest>> {
        return apiService.fetchPRs(owner, repo, state)
    }
}