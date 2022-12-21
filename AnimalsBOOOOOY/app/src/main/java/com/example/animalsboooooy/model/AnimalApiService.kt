package com.example.animalsboooooy.model

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AnimalApiService {

    private val BASE_URL = "https://uc.appengine.google.com/_ah/conflogin?state=%7EAJKiYcF2xtWppYdXtPcPW6ji3PX2AF0Z4pX0DKD3uyDiRz00_FfQG3jwkuP2gZdbTmedGg8yjC8St6SPDfD0l7BrjxE-qbbryTV5-HpOzuWkW_uHzWhGuwaHjaI9Ekn5DAwYY-l0zmu6tdIsygeQB8fjw_wV7Ceeku1yo_NDHAEvYKvSp1DIiPaTjttIhHHBTWlISx6Sjr-oYhX2ggUE0wmVlzAgcCNCiKaL9SgCQ9MzACLjKgcXSiU&pli=1"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(AnimalApi::class.java)

    fun getApiKey(): Single<ApiKey> {
        return api.getApiKey()
    }

    fun getAnimals(key: String):Single<List<Animal>> {
        return api.getAnimals(key)
    }
}