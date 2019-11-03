package com.androdev.unsplashapp.data.vos
import com.google.gson.annotations.SerializedName


data class SponsorshipVO (

	@SerializedName("impression_urls") val impression_urls : List<String>,
	@SerializedName("impressions_id") val impressions_id : Int,
	@SerializedName("tagline") val tagline : String,
	@SerializedName("sponsor") val sponsor : SponsorVO
)