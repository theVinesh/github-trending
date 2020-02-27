package app.vineshbuilds.githubtrending

import app.vineshbuilds.githubtrending.ui.mainpage.vms.MainVm
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@ExperimentalCoroutinesApi
val applicationModule = module {

    viewModel { MainVm(get()) }

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubRepoService::class.java)
    }

}
