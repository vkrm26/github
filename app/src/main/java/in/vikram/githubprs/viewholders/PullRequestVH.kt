package `in`.vikram.githubprs.viewholders

import `in`.vikram.githubprs.R
import `in`.vikram.githubprs.data.remote.model.responses.PullRequest
import android.content.Context
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

class PullRequestVH(val context: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var imgProduct : ImageView = itemView.findViewById(R.id.img_user)
    private var txtTitle : TextView = itemView.findViewById(R.id.txt_title)
    private var txtCreatedDate : TextView = itemView.findViewById(R.id.txt_created_date)
    private var txtClosedDate : TextView = itemView.findViewById(R.id.txt_closed_date)
    private var txtUserName : TextView = itemView.findViewById(R.id.txt_user_name)

    fun bindData(pullRequest: PullRequest) {

        Glide.with(imgProduct.context)
            .load(pullRequest.user?.avatarUrl)
            .transform(CircleCrop())
            .into(imgProduct)

        txtTitle.text = pullRequest.title

        if (!TextUtils.isEmpty(pullRequest.createdAt)) {
            txtCreatedDate.text =
                context.getText(R.string.created_date).toString().plus(" : ").plus(pullRequest.createdAt)
        }

        if (!TextUtils.isEmpty(pullRequest.closedAt)) {
            txtClosedDate.text =
                context.getText(R.string.closed_date).toString().plus(" : ").plus(pullRequest.closedAt)
        }

        txtUserName.text = context.getText(R.string.raised_by).toString().plus("  ").plus(pullRequest.user?.login)
    }

}