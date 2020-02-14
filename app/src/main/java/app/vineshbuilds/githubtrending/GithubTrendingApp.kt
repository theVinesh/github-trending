package app.vineshbuilds.githubtrending

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GithubTrendingApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(applicationModule)
        }
    }
}
