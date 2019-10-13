package com.snaptech.user_operations;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class RentExp extends BroadcastReceiver {
  
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        SharedPreferences preferences;
     //  String rentdate = sp.getString("rentdate","");

        NotificationHelper notificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification();
        notificationHelper.getManager().notify(1, nb.build());

        throw new UnsupportedOperationException("Not yet implemented");
    }

//    public void Notify() {
//        NotificationCompat.Builder mBuilder =
//                new NotificationCompat.Builder(et);
//        NotificationManager mNotificationManager;
//        PendingIntent pendingIntent = null;
//
//        pendingIntent = PendingIntent.getActivity(this, 0, new Intent(et), PendingIntent.FLAG_UPDATE_CURRENT);
//
//        mBuilder
//                .setSmallIcon(R.mipmap.hall2_round)
//                .setContentIntent(pendingIntent)
//                .setAutoCancel(true)
//                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
//                .setStyle(new NotificationCompat.MessagingStyle(content)
//                        .setConversationTitle(title)
//                        .addMessage("", 1, null)) // null means device's user
//
//                .build();
//
//        mNotificationManager =
//                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        assert mNotificationManager != null;
//
//        int m = (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
//
//        mNotificationManager.notify(m, mBuilder.build());
//    }
}
