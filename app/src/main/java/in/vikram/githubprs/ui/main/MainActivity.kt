package `in`.vikram.githubprs.ui.main

import `in`.vikram.githubprs.adapters.PullRequestRVAdapter
import `in`.vikram.githubprs.custom.Resource
import `in`.vikram.githubprs.custom.Status.ERROR
import `in`.vikram.githubprs.custom.Status.LOADING
import `in`.vikram.githubprs.custom.Status.SUCCESS
import `in`.vikram.githubprs.data.remote.model.responses.PullRequest
import `in`.vikram.githubprs.databinding.ActivityMainBinding
import `in`.vikram.githubprs.viewmodel.MainViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding ?= null
    private var viewModel : MainViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding?.let {  setContentView(binding!!.root) }

        binding?.rvPrView?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel?.getPRListLiveData()?.observe(this, this::handlePullRequestResponse)


        binding?.imgRetry?.setOnClickListener {
            viewModel?.fetchClosedPRs()
        }

    }


    private fun handlePullRequestResponse(prListResource : Resource<List<PullRequest>>) {
        when(prListResource.status) {
            SUCCESS -> {
                binding?.rvPrView?.visibility = View.VISIBLE
                binding?.imgRetry?.visibility = View.GONE
                binding?.progressBar?.visibility = View.GONE
                binding?.rvPrView?.adapter = PullRequestRVAdapter(applicationContext, prListResource.data!!)
            }
            ERROR -> {
                binding?.progressBar?.visibility = View.GONE
                binding?.rvPrView?.visibility = View.GONE
                binding?.imgRetry?.visibility = View.VISIBLE
            }
            LOADING -> {
                binding?.progressBar?.visibility = View.VISIBLE
                binding?.rvPrView?.visibility = View.GONE
                binding?.imgRetry?.visibility = View.GONE
            }
        }

    }

}