package com.gebeya.eventnotifier.ui.components

import android.app.NotificationManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import com.gebeya.eventnotifier.R
import kotlin.random.Random

class EventNotification(
    val context: Context
) {

    val notificationManager = context.getSystemService(NotificationManager::class.java)

    fun basicNotification(titile: String, body: String){
        val notification = NotificationCompat.Builder(context, "event_notification")
            .setContentTitle(titile)
            .setContentText(body)
            .setSmallIcon(R.mipmap.ic_app_icon_foreground)
            .setAutoCancel(true)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .build()

        notificationManager.notify(
            Random.nextInt(),
            notification
        )
    }

    fun expandableNotification(titile: String, body: String){
        val notification = NotificationCompat.Builder(context, "event_notification")
            .setContentTitle(titile)
            .setContentText(body)
            .setSmallIcon(R.mipmap.ic_app_icon_foreground)
            .setLargeIcon(
                context.resourceToBitmap(
                    R.drawable.event_ph
                )
            )
            .setStyle(
                NotificationCompat
                    .BigPictureStyle()
                    .bigPicture(
                        context.resourceToBitmap(
                            R.drawable.event_ph
                        )
                    )
            )
            .setAutoCancel(true)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .build()

        notificationManager.notify(
            Random.nextInt(),
            notification
        )

    }

}

fun Context.resourceToBitmap(
    resId: Int
): Bitmap{
    return BitmapFactory.decodeResource(
        resources,
        resId
    )
}