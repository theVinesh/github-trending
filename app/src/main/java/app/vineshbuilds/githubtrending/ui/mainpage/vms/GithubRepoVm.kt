package app.vineshbuilds.githubtrending.ui.mainpage.vms

import androidx.lifecycle.ViewModel
import app.vineshbuilds.githubtrending.ui.mainpage.models.GithubRepoModel

class GithubRepoVm(githubRepoModel: GithubRepoModel) : ViewModel() {
    val repoName = githubRepoModel.repoName
    val avatarUrl = githubRepoModel.avatarUrl
    val authorName = githubRepoModel.authorName
    val description = githubRepoModel.description
    val lang = githubRepoModel.lang ?: "???"
    val stars = githubRepoModel.stars.format()
    val forks = githubRepoModel.forks.format()
    val langColor = githubRepoModel.langColor

    private fun Int.format() = String.format("%,d", this)
}
