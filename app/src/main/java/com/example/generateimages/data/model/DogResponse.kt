package com.example.generateimages.data.model

import com.google.gson.annotations.SerializedName

data class DogResponse(
    @SerializedName("message") var message: String,
    @SerializedName("status") var status: String,
)
