package app.vineshbuilds.githubtrending

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import app.vineshbuilds.commons.dataBinding.ViewProvider
import app.vineshbuilds.commons.dataBinding.viewBinder
import app.vineshbuilds.commons.dataBinding.viewProvider
import app.vineshbuilds.githubtrending.databinding.ItemRepositoryBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainVm(private val repoService: RepoService) : ViewModel() {
    val data = ObservableArrayList<RepositoryVm>()

    init {
        getRepos()
    }

    val viewProvider = viewProvider {
        when (it) {
            is RepositoryVm -> R.layout.item_repository
            else -> ViewProvider.NULL_VIEW
        }
    }

    val viewBinder = viewBinder { viewModel, binding ->
        when (binding) {
            is ItemRepositoryBinding -> binding.vm = viewModel as? RepositoryVm
        }
    }

    private fun getRepos() {
        CoroutineScope(Dispatchers.IO).launch {
            repoService.getRepos().map { RepositoryVm(it) }.let(data::addAll)
        }
    }
}
