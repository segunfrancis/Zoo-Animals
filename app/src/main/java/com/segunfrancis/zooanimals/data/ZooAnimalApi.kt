package com.segunfrancis.zooanimals.data

import retrofit2.http.GET
import retrofit2.http.Path

interface ZooAnimalApi {

    @GET("animals/rand/{number}")
    suspend fun getRandomAnimals(@Path("number") number: Int = 10) : BaseZooResponse
}
