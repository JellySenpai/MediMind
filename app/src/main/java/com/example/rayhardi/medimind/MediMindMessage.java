package com.example.rayhardi.medimind;

import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;



/**
 * Created by rayhardi on 10/15/2017.
 */

public class MediMindMessage extends FirebaseMessagingService {
    private static final String TAG = "FCM Service";
    @Override
    public void onMessageReceived (RemoteMessage remoteMessage)
    {
        String remoteMess = remoteMessage.getNotification().getBody();
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message Body: " + remoteMess);

        NotificationCompat.Builder builder;
        int notificationId = 7;

        builder = new NotificationCompat.Builder(this).setSmallIcon(R.drawable.brain)
                .setContentTitle("Medication Reminder").setContentText(remoteMess);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId, builder.build());
    }
}
