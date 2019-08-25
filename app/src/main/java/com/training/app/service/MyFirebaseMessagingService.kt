package com.training.app.service

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.training.app.MainActivity

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        if (remoteMessage.notification!!.body != null) {

        }
    }

  @RequiresApi(Build.VERSION_CODES.O)
  fun showNotification(title: String, content: String) {

      val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

      val notificationID = 101
      val resultIntent = Intent(this, MainActivity::class.java)

      val pendingIntent = PendingIntent.getActivity(
          this,
          0,
          resultIntent,
          PendingIntent.FLAG_UPDATE_CURRENT
      )

      val channelID = "com.ebookfrenzy.notifydemo.news"

      val notification = Notification.Builder(applicationContext, channelID)
          .setContentTitle(title)
          .setContentText(content)
          .setSmallIcon(android.R.drawable.ic_dialog_info)
          .setChannelId(channelID)
          .setContentIntent(pendingIntent)
          .build()

      notificationManager.notify(notificationID, notification)
  }

}