package `in`.vikram.githubprs.adapters

import `in`.vikram.githubprs.R
import `in`.vikram.githubprs.data.remote.model.responses.PullRequest
import `in`.vikram.githubprs.viewholders.PullRequestVH
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PullRequestRVAdapter(val context: Context, var prList : List<PullRequest>) : RecyclerView.Adapter<PullRequestVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullRequestVH {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_pr_view, parent, false)
        return PullRequestVH(context, itemView)
    }

    override fun onBindViewHolder(holder: PullRequestVH, position: Int) {
        holder.bindData(prList[holder.adapterPosition])
    }

    override fun getItemCount(): Int {
        return prList.size
    }
}