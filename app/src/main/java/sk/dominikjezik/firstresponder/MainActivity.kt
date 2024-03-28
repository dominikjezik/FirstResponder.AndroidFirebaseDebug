package sk.dominikjezik.firstresponder

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.google.firebase.messaging.FirebaseMessaging
import sk.dominikjezik.firstresponder.ui.theme.FirstResponderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // FCM get token
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.d("FirstResponder.Firebase", "Fetching FCM registration token failed", task.exception)
                return@addOnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result
            Log.d("FirstResponder.Firebase", "FCM token: $token")
        }

        // Subscribe to topic
        FirebaseMessaging.getInstance().subscribeToTopic("incidents-request-location")

        setContent {
            FirstResponderTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Pre výstup pozrite nástroj Logcat v Android Studio s filtrom \"FirstResponder.Firebase\"",
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}