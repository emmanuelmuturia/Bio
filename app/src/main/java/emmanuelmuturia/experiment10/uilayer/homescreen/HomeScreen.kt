package emmanuelmuturia.experiment10.uilayer.homescreen

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavHostController
import emmanuelmuturia.experiment10.navigationlayer.Routes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun HomeScreen(navController: NavHostController) {

    // Create a state to track the visibility of the Biometric Authentication Dialog...
    var isAuthenticationDialogVisible by remember { mutableStateOf(false) }

    // Create a context for the Toast...
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Click the button to find your treasure...",
            fontSize = 14.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(height = 7.dp))
        Button(
            onClick = {
                // Show the Biometric Authentication Dialog...
                isAuthenticationDialogVisible = true
            }
        ) {
            Text(text = "Click Me")
        }

        // Biometric Authentication Dialog...
        if (isAuthenticationDialogVisible) {
            Authenticate(
                onAuthenticationSuccess = {
                    // Close the Dialog on success...
                    isAuthenticationDialogVisible = false
                    // Navigate to the Destination Screen...
                    navController.navigate(route = Routes.DestinationScreen.route)
                },
                onAuthenticationError = {
                    // Close the Dialog on error...
                    isAuthenticationDialogVisible = false
                    // Handle authentication error here...
                    Toast.makeText(context, "Authentication Failed!!!", Toast.LENGTH_LONG).show()
                }
            )
        }
    }
}

@Composable
fun Authenticate(
    onAuthenticationSuccess: () -> Unit,
    onAuthenticationError: (String) -> Unit
) {
    val biometricPrompt = CreateBiometricPrompt(
        onAuthenticationSuccess, onAuthenticationError
    )

    val promptInfo = createBiometricPromptInfo()

    // Start biometric authentication...
    biometricPrompt.authenticate(promptInfo)
}

@Composable
fun CreateBiometricPrompt(
    onAuthenticationSuccess: () -> Unit,
    onAuthenticationError: (String) -> Unit
): BiometricPrompt {

    val context = LocalContext.current
    val executor = Dispatchers.Main.asExecutor()

    return BiometricPrompt(
        context as FragmentActivity,
        executor,
        object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                onAuthenticationSuccess()
            }

            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                onAuthenticationError(errString.toString())
            }
        })
}

private fun createBiometricPromptInfo(): BiometricPrompt.PromptInfo {
    return BiometricPrompt.PromptInfo.Builder().setTitle("Biometric Authentication")
        .setSubtitle("Authenticate using your fingerprint...")
        .setDescription("Please place your finger on the fingerprint sensor...")
        .setConfirmationRequired(true).setNegativeButtonText("Cancel").build()
}