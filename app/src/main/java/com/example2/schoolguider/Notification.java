package com.example2.schoolguider;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import androidx.core.app.NotificationCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example2.schoolguider.databinding.NotificationActivityBinding;

public class Notification extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private NotificationActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button notification;

        binding = NotificationActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /*
        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_notification);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        notification = findViewById(R.id.notificationButton);

        notification.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String message = "Notification Enabled: ";
                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        Notification.this
                )
                        .setSmallIcon(R.drawable.ic_baseline_circle_notifications_24)
                        .setContentTitle("Notification: School Guider")
                        .setContentText(message)
                        .setAutoCancel(true);

                Intent intent = new Intent(Notification.this,
                        SettingsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("message", message);

                PendingIntent pendingIntent = PendingIntent.getActivity(Notification.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                builder.setContentIntent(pendingIntent);

                NotificationManager notificationManager = (NotificationManager)getSystemService(
                        Context.NOTIFICATION_SERVICE
                );

                notificationManager.notify(0, builder.build());
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_notification);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}