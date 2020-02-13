package app.vineshbuilds.githubtrending

data class RepositoryModel(
    val repoName: String, val avatarUrl: String, val authorName: String,
    val description: String, val lang: String, val stars: Int,
    val forks: Int, val langColor: String
)
