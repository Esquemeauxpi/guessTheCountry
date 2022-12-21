package com.example.animalsboooooy.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.animalsboooooy.model.Animal
import com.example.animalsboooooy.model.AnimalApiService
import com.example.animalsboooooy.model.ApiKey
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import androidx.lifecycle.MutableLiveData as MutableLiveData1

class ListViewModel (application: Application): AndroidViewModel(application) {

    val animals by lazy { MutableLiveData1<List<Animal>>() }
    val loadError by lazy { MutableLiveData1<Boolean>() }
    val loading by lazy { MutableLiveData1<Boolean>() }

    private val disposable = CompositeDisposable()
    private val apiService = AnimalApiService()

    fun refresh() {
        getKey()
    }

    private fun getKey() {
        disposable.add(
            apiService.getApiKey()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<ApiKey>() {
                    override fun onSuccess(key: ApiKey) {
                        if(key.key.isNullOrEmpty()) {
                            loadError.value = true
                            loading.value = false
                        }  else {
                            getAnimals(key.key)
                        }
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                        loading.value = false
                        loadError.value = true
                    }

                })
        )
    }

    private fun getAnimals(key: String) {
        disposable.add(
            apiService.getAnimals(key)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<List<Animal>>() {
                    override fun onSuccess(list: List<Animal>) {
                        loadError.value = false
                        animals.value = list
                        loading.value = false
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                        loading.value = false
                        animals.value = null
                        loadError.value = true
                    }

                })
        )

    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}