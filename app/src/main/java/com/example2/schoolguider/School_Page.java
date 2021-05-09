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

import android.view.View;
import android.widget.Button;

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