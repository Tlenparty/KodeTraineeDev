package com.geekbrains.kodetraineedev.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object KodeTrainingApiFactory {

    private const val BASE_URL = "https://stoplight.io/mocks/kode-education/trainee-test/25143926/"

    fun create(): KodeTrainingApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .build()
            )
            // Для конвертации ответов с сервера в реактив
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            // Для конвертации GSON
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KodeTrainingApi::class.java)
}