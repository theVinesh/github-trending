package app.vineshbuilds.githubtrending

import app.vineshbuilds.githubtrending.ui.mainpage.models.GithubRepoModel
import retrofit2.http.GET

interface GithubRepoService {
    @GET("repositories")
    suspend fun getRepos(): List<GithubRepoModel>
}
