package app.vineshbuilds.githubtrending.ui.mainpage.vms

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.vineshbuilds.commons.dataBinding.ViewProvider
import app.vineshbuilds.commons.dataBinding.viewBinder
import app.vineshbuilds.commons.dataBinding.viewProvider
import app.vineshbuilds.githubtrending.BR
import app.vineshbuilds.githubtrending.GithubRepoService
import app.vineshbuilds.githubtrending.R
import app.vineshbuilds.githubtrending.Result.*
import app.vineshbuilds.githubtrending.fetch
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MainVm(private val githubRepoService: GithubRepoService) : ViewModel() {
    val isRefreshing = ObservableBoolean(false)
    val data = ObservableArrayList<ViewModel>()
    private var getRepoJob: Job? = null

    init {
        refreshRepos()
    }

    val viewProvider = viewProvider {
        when (it) {
            is GithubRepoVm -> R.layout.item_repository
            is LoadingVm -> R.layout.item_loading
            is ErrorVm -> R.layout.item_error
            else -> ViewProvider.NULL_VIEW
        }
    }

    val viewBinder = viewBinder { viewModel, binding ->
        binding.setVariable(BR.vm, viewModel)
    }

    @ExperimentalCoroutinesApi
    fun refreshRepos() {
        getRepoJob?.cancel()
        getRepoJob = viewModelScope.launch {
            isRefreshing.set(true)
            fetch { githubRepoService.getRepos() }.collect { result ->
                when (result) {
                    is Loading -> (0 until 25).map { LoadingVm.INSTANCE }
                    is Success -> result.data.map { GithubRepoVm(it) }
                    is Failure -> listOf(ErrorVm())
                }.let {
                    isRefreshing.set(false)
                    data.clear()
                    data.addAll(it)
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}
