package app.vineshbuilds.githubtrending

import androidx.lifecycle.ViewModel

class RepositoryVm(repositoryModel: RepositoryModel) : ViewModel() {
    val repoName = repositoryModel.repoName
    val avatarUrl = repositoryModel.avatarUrl
    val authorName = repositoryModel.authorName
    val description = repositoryModel.description
    val lang = repositoryModel.lang
    val stars = repositoryModel.stars
    val forks = repositoryModel.forks
    val langColor = repositoryModel.langColor
}
