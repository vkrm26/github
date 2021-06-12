package `in`.vikram.githubprs.viewmodel

import `in`.vikram.githubprs.Injection
import `in`.vikram.githubprs.custom.PRState
import `in`.vikram.githubprs.custom.Resource
import `in`.vikram.githubprs.custom.Resource.Companion
import `in`.vikram.githubprs.data.DataSourceInterface
import `in`.vikram.githubprs.data.remote.model.responses.PullRequest
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val TAG = "MainViewModel"
    private var dataRepository: DataSourceInterface = Injection.provideDataRepository(application.applicationContext)
    private var compositeDisposable : CompositeDisposable = CompositeDisposable()
    private var prListResource  = MutableLiveData<Resource<List<PullRequest>>>()


    init {
        fetchClosedPRs()
    }

    fun getPRListLiveData() : LiveData<Resource<List<PullRequest>>> {
        return prListResource
    }


    fun fetchClosedPRs() {
        prListResource.value = Resource.loading(emptyList())
        compositeDisposable.add(dataRepository.fetchPRs(PRState.CLOSED.getValue())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                {
                    prListResource.value = Resource.success(it)
                },

                {
                    prListResource.value = Resource.error(it.localizedMessage, emptyList())
                }))
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared")
    }

}