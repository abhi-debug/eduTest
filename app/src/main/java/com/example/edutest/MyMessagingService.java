package com.example.edutest;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        showNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
    }

public void showNotification(String title,String message){

    NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"MyNotifications")
            .setContentTitle(title)
            .setSmallIcon(R.drawable.common_google_signin_btn_icon_dark)
            .setAutoCancel(true)
            .setContentText(message);

    NotificationManagerCompat managerCompat= NotificationManagerCompat.from(this);
    managerCompat.notify(999, builder.build());
}


}
