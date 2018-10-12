package com.example.mohit_pc.fsai;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Alerts extends Service {
    boolean isRunningFirst = true;
    ArrayList<AlertBluePrint> alerts = new ArrayList<>();
    public Alerts() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        listenAlerts();
        return null;
    }


    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        listenAlerts();
    }

    void listenAlerts(){
        String path = "alerts/";
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(path);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                alerts.clear();
                Toast.makeText(Alerts.this, "Data received", Toast.LENGTH_SHORT).show();
                for(DataSnapshot child : dataSnapshot.getChildren()){
                    alerts.add(child.getValue(AlertBluePrint.class));
                }

                notification();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
    void notification() {
        if (isRunningFirst) {
            isRunningFirst = false;
            return;
        }

        AlertBluePrint latest = alerts.get(alerts.size() - 1);
//        Toast.makeText(this, "Msg: " + latest.getMessage(), Toast.LENGTH_SHORT).show();
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(Alerts.this, "12")
                .setSmallIcon(R.drawable.logofsai)
                .setContentTitle(latest.getTitle())
                .setContentText(latest.getMessage())
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(latest.getMessage()))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//        mBuilder.notify();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        NotificationManager notificationManagerOreo = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        if(notificationManagerOreo == null){
            Toast.makeText(this, "Error in manager", Toast.LENGTH_SHORT).show();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            /* Create or update. */
            NotificationChannel channel = new NotificationChannel("01",
                    "channel",   NotificationManager.IMPORTANCE_DEFAULT);
            notificationManagerOreo.createNotificationChannel(channel);
//            notificationManagerOreo.createNotificationChannel();
            notificationManagerOreo.notify(58,mBuilder.build());
        }else {

            notificationManager.notify(58, mBuilder.build());

        }



    }

}
