package com.example2.schoolguider;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example2.schoolguider.databinding.DailyNotificationBinding;
import java.text.DateFormat;

import java.util.Calendar;

public class DailyNotification extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    private TextView alarmText;

    private AppBarConfiguration appBarConfiguration;
    private DailyNotificationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        alarmText = findViewById(R.id.alarmSet);

        binding = DailyNotificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.action_FirstFragment_to_SecondFragment);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Back to Home", Snackbar.LENGTH_LONG)
                        .setAction("Continue", new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(DailyNotification.this, MainActivity.class));
                            }
                        })
                        .setTextColor(getResources().getColor(R.color.grades))
                        .setActionTextColor(getResources().getColor(R.color.reading))
                        .show();
            }
        });

        // Time Picker Button
        Button buttonTimePicker = findViewById(R.id.dailyNotification);
        buttonTimePicker.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);

                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "Time Picker");
            }
        });

        Button buttonCancelAlarm = findViewById(R.id.cancelAlarm);
        Button buttonCreateAlarm = findViewById(R.id.createAlarm);

        buttonCancelAlarm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.action_FirstFragment_to_SecondFragment);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // This method sets an alarm once a time is set
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);

        updateTimeText(calendar);
        startAlarm(calendar);
    }

    public void updateTimeText(Calendar calendar) {
        String timeText = "Your Schedule is Starting at: ";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(calendar.getTime());
        timeText += "!";

        alarmText.setText(timeText);
    }

    public void startAlarm(Calendar calendar) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        if (calendar.before(Calendar.getInstance())) {
            calendar.add(Calendar.DATE, 1);
        }

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }

    public void cancelAlarm() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        alarmManager.cancel(pendingIntent);
        alarmText.setText(getResources().getString(R.string.alarm_cancel));
    }
}