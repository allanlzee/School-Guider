package com.example2.schoolguider;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlarmNotification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_notification_activity);

        // Call Notification Channel
        createNotificationChannel();

        Button reminder = findViewById(R.id.reminder);
        reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AlarmNotification.this, "Reminder Set!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AlarmNotification.this, ReminderBroadcast.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(AlarmNotification.this, 0, intent, 0);

                // Alarm system
                AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);

                long timeAtButtonClick = System.currentTimeMillis();
                long oneHour = 60000 * 60 * 10;

                alarm.set(AlarmManager.RTC_WAKEUP, timeAtButtonClick + oneHour, pendingIntent);
            }
        });
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "ScheduleReminder";
            String description = "Channel for Schedule ReminderBroadcast";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("scheduleReminder", name, importance);
            channel.setDescription(description);
        }
    }
}