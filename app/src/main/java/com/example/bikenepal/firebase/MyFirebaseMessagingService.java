package com.example.bikenepal.firebase;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.example.bikenepal.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {


    private static final String TAG = "BikeFirebaseMessagingService";
    private static final String CHANNEL_ID = "BikeNotify";


    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {

        if(remoteMessage.getData().size() > 0) {

            // You can access the data payload using remoteMessage.getData()
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());

        }

        if(remoteMessage.getNotification() != null) {

            Log.d(TAG, "Message notification body: " + remoteMessage.getNotification().getBody());

            // Handle the notification payload here
            showNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());

        }
    }


    @Override
    public void onNewToken(String token) {

        Log.d(TAG, "Refreshed token " + token);

    }


    private void showNotification(String title, String body) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "BikeNotify")
                .setSmallIcon(R.drawable.motorbike)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManager notificationManager = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);


        if (notificationManager != null) {
            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "channel_name";
                String description = "channel_description";
                int importance = NotificationManager.IMPORTANCE_DEFAULT;
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
                channel.setDescription(description);

                notificationManager.createNotificationChannel(channel);

            }

            notificationManager.notify(0, builder.build());

        } else {
            // Handle case where getSystemService() returned null
            Log.e(TAG, "NotificationManager is null");

        }
    }

}

