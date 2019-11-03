package com.androdev.unsplashapp.data.vos
import com.google.gson.annotations.SerializedName

data class ProfileImageVO (

	@SerializedName("small") val small : String,
	@SerializedName("medium") val medium : String,
	@SerializedName("large") val large : String
)