package `in`.vikram.githubprs.data.remote.model.responses

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class PullRequest {

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("state")
    @Expose
    var state: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("user")
    @Expose
    var user: User? = null

    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null

    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null

    @SerializedName("closed_at")
    @Expose
    var closedAt: String? = null
}