package com.example2.schoolguider;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class School_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school__page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Button Navigation System
        Button gradesButton = (Button) findViewById(R.id.gradesButton);
        Button achievementsButton = (Button) findViewById(R.id.achievementsButton);
        Button goalsButton = (Button) findViewById(R.id.goalsButton);

        gradesButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(School_Page.this, Course_Grades.class));
            }
        });

        achievementsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(School_Page.this, Achievements_Starter.class));
            }
        });

        goalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(School_Page.this, Goals_Starter.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.nav_home:
                Toast.makeText(School_Page.this, "Settings", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(School_Page.this, SettingsActivity.class));
                /* Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                ActivityOptions transition = ActivityOptions.makeSceneTransitionAnimation(this, transitionActivity.toBundle());
                startActivity(intent, transition.toBundle()); */
                return true;
            case R.id.nav_school:
                Toast.makeText(School_Page.this, "School", Toast.LENGTH_SHORT).show();
                // Bring User to School Pages
                startActivity(new Intent(School_Page.this, School_Page.class));
                return true;
            case R.id.nav_schedule:
                Toast.makeText(School_Page.this, "Schedule", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(School_Page.this, School_Schedule.class));
                return true;
            case R.id.nav_mindfulness:
                Toast.makeText(School_Page.this, "Mindfulness", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(School_Page.this, MindfulnessActivity.class));
                return true;
            case R.id.nav_Morning:
                Toast.makeText(School_Page.this, "Good Morning!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(School_Page.this, MorningActivitiesPage.class));
                return true;
            case R.id.nav_Afternoon:
                Toast.makeText(School_Page.this, "Good Afternoon!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(School_Page.this, AfternoonActivitiesPage.class));
                return true;
            case R.id.nav_Evening:
                Toast.makeText(School_Page.this, "Good Evening!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(School_Page.this, EveningActivitiesPage.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onGradesClick(View view) {
         //NavController activityToGrades = Navigation.findNavController(School_Page.this, R.id.action_school_Page_to_gradesFragment);
         //activityToGrades.navigate(R.id.action_school_Page_to_gradesFragment);

         startActivity(new Intent(School_Page.this, Course_Grades.class));
    }

    public void onAchievementsClick(View view) {
        startActivity(new Intent(School_Page.this, Achievements_Starter.class));
    }

    public void onGoalsClick(View view) {
        startActivity(new Intent(School_Page.this, Goals_Starter.class));
    }
}