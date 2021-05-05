package com.example2.schoolguider;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {

    private Spinner notificationSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new SettingsFragment())
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        notificationSpinner = (Spinner) findViewById(R.id.notificationSpinner);

        ArrayList<String> activities = new ArrayList<String>();
        activities.add("School Schedule");
        activities.add("School Tracker");
        activities.add("Mindfulness");


        ArrayAdapter<String> notificationSpinnerAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, activities
        );

        notificationSpinner.setAdapter(notificationSpinnerAdapter);

        // Set onClickListener
        notificationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SettingsActivity.this, activities.get(position) + " Selected", Toast.LENGTH_SHORT).show();
                // TODO: mute notifications for the activity selected
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(SettingsActivity.this, "Select Muted Activities", Toast.LENGTH_SHORT).show();
            }
        });

        TextView textView = findViewById(R.id.notification);

        String message = getIntent().getStringExtra("message");

        textView.setText(message);
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }

}