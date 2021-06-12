package `in`.vikram.githubprs.data.remote


import `in`.vikram.githubprs.data.remote.model.responses.PullRequest
import io.reactivex.Single

interface ApiHelper {

    /****************** RELATED TO PRs ***********************/

    fun fetchPRs(owner : String, repo : String, state : String) : Single<List<PullRequest>>

}