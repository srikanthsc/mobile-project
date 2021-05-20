package com.srikanthsc.myapplication;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
// probleme a regler pour la notifiacation
//quelque probleme au niveau de la notifiacation
public class MyFirebase extends FirebaseMessagingService {

    private static final String CANAL ="MyNotifCanal" ;

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String myMessage=remoteMessage.getNotification().getBody();
        Log.d("firebase", "notif" + myMessage);

        NotificationCompat.Builder notificationBuilder= new NotificationCompat.Builder(this,CANAL);
        notificationBuilder.setContentTitle("notif");
        notificationBuilder.setContentText(myMessage);
        //notificationBuilder.setSmallIcon(R.drawable.bell);

        NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            String channelId = getString(R.string.notification_channel_id);
            String channelTitle = getString(R.string.notification_channel_title);
            String channelDescription = getString(R.string.notification_channel_desc);
            NotificationChannel channel= new NotificationChannel(channelId,channelTitle,NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(channelDescription);
            notificationManager.createNotificationChannel(channel);
            notificationBuilder.setChannelId(channelId);

        }
        notificationManager.notify(1,notificationBuilder.build());

    }
}
