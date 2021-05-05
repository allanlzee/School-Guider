package com.example2.schoolguider;

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
                NavController activityToGrades = Navigation.findNavController(School_Page.this, R.id.action_school_Page_to_FirstFragment2);
                activityToGrades.navigateUp();
                activityToGrades.navigate(R.id.action_school_Page_to_FirstFragment2);
            }
        });
    }

    public void onGradesClick(View view) {
         //NavController activityToGrades = Navigation.findNavController(School_Page.this, R.id.action_school_Page_to_Grades);
         //activityToGrades.navigateUp();
         //activityToGrades.navigate(R.id.action_school_Page_to_Grades);


    }

    public void onAchievementsClick(View view) {
        //NavController activityToAchievements = Navigation.findNavController(School_Page.this, R.id.action_school_Page_to_Achievements);
        //activityToAchievements.navigateUp();
        //activityToAchievements.navigate(R.id.action_school_Page_to_Achievements);
    }

}