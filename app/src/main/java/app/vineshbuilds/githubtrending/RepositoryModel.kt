package app.vineshbuilds.githubtrending

import com.google.gson.annotations.SerializedName

data class RepositoryModel(
    @SerializedName("name")
    val repoName: String,
    @SerializedName("avatar")
    val avatarUrl: String,
    @SerializedName("author")
    val authorName: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("language")
    val lang: String,
    @SerializedName("stars")
    val stars: Int,
    @SerializedName("forks")
    val forks: Int,
    @SerializedName("languageColor")
    val langColor: String
)
