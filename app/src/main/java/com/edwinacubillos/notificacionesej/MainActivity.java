package com.edwinacubillos.notificacionesej;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText eContentText, eContentInfo, eContentTitle, eTicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eContentInfo = findViewById(R.id.eContentInfo);
        eContentText = findViewById(R.id.eContentText);
        eContentTitle = findViewById(R.id.eTitle);
        eTicker = findViewById(R.id.eTicker);
    }

    public void notificar(View view) {

        Intent intent = new Intent(MainActivity.this, Main2Activity.class);

        PendingIntent contIntent = PendingIntent.getActivity(this, 0,
                intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);


        builder.setContentTitle(eContentTitle.getText().toString())
                .setContentText(eContentText.getText().toString())
                .setTicker(eTicker.getText().toString())
                .setContentInfo(eContentInfo.getText().toString())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(contIntent)
                .setAutoCancel(true)
                .setSound(notification)
                .setVibrate(new long[] { 1000, 1000})
                .setLights(Color.RED, 3000, 3000);


        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(1,builder.build());
    }
}
