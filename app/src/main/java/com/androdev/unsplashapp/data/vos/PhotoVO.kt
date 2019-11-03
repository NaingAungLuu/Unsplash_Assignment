package com.androdev.unsplashapp.data.vos
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "photos")
data class PhotoVO (

	@PrimaryKey
	@ColumnInfo(name = "id")
	@SerializedName("id")
	var id : String,

	@ColumnInfo(name ="created_at")
	@SerializedName("created_at")
	var created_at : String?,

	@ColumnInfo(name= "updated_at")
	@SerializedName("updated_at")
	var updated_at : String?,

	@ColumnInfo(name = "promoted_at" )
	@SerializedName("promoted_at")
	var promoted_at : String?,

	@ColumnInfo(name = "width")
	@SerializedName("width")
	var width : Int?,

	@ColumnInfo(name = "height")
	@SerializedName("height")
	var height : Int?,

	@ColumnInfo(name = "color")
	@SerializedName("color")
	var color : String?,

	@ColumnInfo(name = "description")
	@SerializedName("description")
	var description : String?,

	@ColumnInfo(name = "alt_description")
	@SerializedName("alt_description")
	var alt_description : String?,

	@ColumnInfo(name = "urls")
	@SerializedName("urls")
	var urls : UrlsVO?,

	@ColumnInfo(name = "links")
	@SerializedName("links")
	var links : LinksVO?,

	@ColumnInfo(name = "categories")
	@SerializedName("categories")
	var categories : List<String>?,

	@ColumnInfo(name = "likes")
	@SerializedName("likes")
	var likes : Int?,

	@ColumnInfo(name = "liked_by_user")
	@SerializedName("liked_by_user")
	var liked_by_user : Boolean?,

	@ColumnInfo(name = "current_user_collections")
	@SerializedName("current_user_collections")
	var current_user_collections : List<String>,

	@ColumnInfo(name = "user")
	@SerializedName("user")
	var user : UserVO?,

	@ColumnInfo(name = "sponsorship")
	@SerializedName("sponsorship")
	var sponsorship : SponsorshipVO?

){

}