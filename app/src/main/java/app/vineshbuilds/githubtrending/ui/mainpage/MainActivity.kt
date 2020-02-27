package app.vineshbuilds.githubtrending.ui.mainpage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import app.vineshbuilds.githubtrending.R
import app.vineshbuilds.githubtrending.databinding.ActivityMainBinding
import app.vineshbuilds.githubtrending.ui.mainpage.vms.MainVm
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    @ExperimentalCoroutinesApi
    private val viewModel: MainVm by viewModel()

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this,
                R.layout.activity_main
            )
        binding.vm = viewModel
    }
}
