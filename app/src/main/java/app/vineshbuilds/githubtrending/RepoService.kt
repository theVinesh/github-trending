package app.vineshbuilds.githubtrending

import retrofit2.http.GET

interface RepoService {
    @GET("repositories")
    suspend fun getRepos(): List<RepositoryModel>
}
