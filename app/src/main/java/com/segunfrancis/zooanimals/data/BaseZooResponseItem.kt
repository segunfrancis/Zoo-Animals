package com.segunfrancis.zooanimals.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BaseZooResponseItem(
    @SerializedName(value = "active_time") val activeTime: String,
    @SerializedName(value = "animal_type") val animalType: String,
    @SerializedName(value = "diet") val diet: String,
    @SerializedName(value = "geo_range") val geoRange: String,
    @SerializedName(value = "habitat") val habitat: String,
    @SerializedName(value = "id") val id: Int,
    @SerializedName(value = "image_link") val imageLink: String,
    @SerializedName(value = "latin_name") val latinName: String,
    @SerializedName(value = "length_max") val lengthMax: String,
    @SerializedName(value = "length_min") val lengthMin: String,
    @SerializedName(value = "lifespan") val lifespan: String,
    @SerializedName(value = "name") val name: String,
    @SerializedName(value = "weight_max") val weightMax: String,
    @SerializedName(value = "weight_min") val weightMin: String
) : Parcelable
