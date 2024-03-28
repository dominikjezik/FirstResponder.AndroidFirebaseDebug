package sk.dominikjezik.firstresponder.services

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)

        Log.d("FirstResponder.Firebase", "Refreshed token: $token")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        Log.d("FirstResponder.Firebase", "--- Servis ziskal spravu od Firebase ---")

        val title = message.notification?.title
        val body = message.notification?.body

        val topic = message.from
        val notificationType = message.data["type"]

        Log.d("FirstResponder.Firebase", "Title: $title, Body: $body")
        Log.d("FirstResponder.Firebase", "Topic: $topic")
        Log.d("FirstResponder.Firebase", "Notification type: $notificationType")
        Log.d("FirstResponder.Firebase", "Data: ${message.data}")
    }
}