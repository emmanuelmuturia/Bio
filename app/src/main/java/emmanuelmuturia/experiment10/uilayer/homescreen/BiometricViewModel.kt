package emmanuelmuturia.experiment10.uilayer.homescreen

import android.app.Application
import androidx.biometric.BiometricPrompt
import androidx.compose.ui.platform.LocalContext
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor
import javax.inject.Inject

@HiltViewModel
class BiometricsViewModel @Inject constructor(private val application: Application) :
    AndroidViewModel(application) {


}
