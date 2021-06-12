package `in`.vikram.githubprs.data

import `in`.vikram.githubprs.data.remote.model.responses.PullRequest
import io.reactivex.Single

interface DataSourceInterface {

    fun fetchPRs(state : String) : Single<List<PullRequest>>

}