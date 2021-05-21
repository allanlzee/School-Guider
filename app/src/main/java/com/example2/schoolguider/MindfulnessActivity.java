package com.example2.schoolguider;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example2.schoolguider.ui.main.ui.main.SectionsPagerAdapter;

public class MindfulnessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mindfulness);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);
        FloatingActionButton toAlarm = findViewById(R.id.buttonToAlarm);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Back to Home", Snackbar.LENGTH_LONG)
                        .setAction("Continue", new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(MindfulnessActivity.this, MainActivity.class));
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.goalsButton))
                        .setTextColor(getResources().getColor(R.color.reading))
                        .show();
            }
        });

        toAlarm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Go to Alarm", Snackbar.LENGTH_LONG)
                        .setAction("Continue", new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(MindfulnessActivity.this, DailyNotification.class));
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.morningButton))
                        .setTextColor(getResources().getColor(R.color.schedule))
                        .show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.nav_home:
                Toast.makeText(MindfulnessActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MindfulnessActivity.this, SettingsActivity.class));
                return true;
            case R.id.nav_school:
                Toast.makeText(MindfulnessActivity.this, "School", Toast.LENGTH_SHORT).show();
                // Bring User to School Pages
                startActivity(new Intent(MindfulnessActivity.this, School_Page.class));
                return true;
            case R.id.nav_schedule:
                Toast.makeText(MindfulnessActivity.this, "Schedule", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MindfulnessActivity.this, School_Schedule.class));
                return true;
            case R.id.nav_mindfulness:
                Toast.makeText(MindfulnessActivity.this, "Mindfulness", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MindfulnessActivity.this, MindfulnessActivity.class));
                return true;
            case R.id.nav_Morning:
                Toast.makeText(MindfulnessActivity.this, "Good Morning!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MindfulnessActivity.this, MorningActivitiesPage.class));
                return true;
            case R.id.nav_Afternoon:
                Toast.makeText(MindfulnessActivity.this, "Good Afternoon!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MindfulnessActivity.this, AfternoonActivitiesPage.class));
                return true;
            case R.id.nav_Evening:
                Toast.makeText(MindfulnessActivity.this, "Good Evening!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MindfulnessActivity.this, EveningActivitiesPage.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onMeditationClick(View view) {
        NavController activityToMeditation = Navigation.findNavController(MindfulnessActivity.this,
                R.id.action_mindfulnessActivity_to_mindfulnessFragment1);
        activityToMeditation.navigateUp();
        activityToMeditation.navigate(R.id.action_mindfulnessActivity_to_mindfulnessFragment1);
    }

    public void onMusicClick(View view) {
        NavController activityToMusic =  Navigation.findNavController(MindfulnessActivity.this,
                R.id.action_mindfulnessActivity_to_music_Mindfulness);
        activityToMusic.navigateUp();
        activityToMusic.navigate(R.id.action_mindfulnessActivity_to_music_Mindfulness);
    }

    public void onReadingClick(View view) {
        NavController activityToReading =  Navigation.findNavController(MindfulnessActivity.this,
                R.id.action_mindfulnessActivity_to_mindfulness_Reading);
        activityToReading.navigateUp();
        activityToReading.navigate(R.id.action_mindfulnessActivity_to_mindfulness_Reading);
    }
}