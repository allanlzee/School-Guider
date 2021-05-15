package com.example2.schoolguider;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example2.schoolguider.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;

public class School_Schedule extends AppCompatActivity {

    // Initialize Spinners on the Schedule
    private Spinner morning1;
    private Spinner afternoon1;
    private Spinner evening1;

    private Spinner morning2;
    private Spinner afternoon2;
    private Spinner evening2;

    private Spinner morning3;
    private Spinner afternoon3;
    private Spinner evening3;

    private Spinner morning4;
    private Spinner afternoon4;
    private Spinner evening4;

    // Initialize Buttons
    private Button course1;
    private Button course2;
    private Button course3;
    private Button course4;

    private Button course5;
    private Button course6;
    private Button course7;
    private Button course8;

    private Button course9;
    private Button course10;
    private Button course11;
    private Button course12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school__schedule);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Back to Home", Snackbar.LENGTH_LONG)
                        .setAction("Go", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(School_Schedule.this, MainActivity.class));
                            }
                        })
                        .show();
            }
        });

        // Initialize the Spinners using IDs
        morning1 = findViewById(R.id.spinnerMorning1);
        morning2 = findViewById(R.id.spinnerMorning2);
        morning3 = findViewById(R.id.spinnerMorning3);
        morning4 = findViewById(R.id.spinnerMorning4);

        afternoon1 = findViewById(R.id.spinnerAfternoon1);
        afternoon2 = findViewById(R.id.spinnerAfternoon2);
        afternoon3 = findViewById(R.id.spinnerAfternoon3);
        afternoon4 = findViewById(R.id.spinnerAfternoon4);

        evening1 = findViewById(R.id.spinnerEvening1);
        evening2 = findViewById(R.id.spinnerEvening2);
        evening3 = findViewById(R.id.spinnerEvening3);
        evening4 = findViewById(R.id.spinnerEvening4);

        // Initialize all Buttons
        course1 = findViewById(R.id.morningCourse1);
        course2 = findViewById(R.id.morningCourse2);
        course3 = findViewById(R.id.morningCourse3);
        course4 = findViewById(R.id.morningCourse4);
        course5 = findViewById(R.id.afternoonCourse1);
        course6 = findViewById(R.id.afternoonCourse2);
        course7 = findViewById(R.id.afternoonCourse3);
        course8 = findViewById(R.id.afternoonCourse4);
        course9 = findViewById(R.id.eveningCourse1);
        course10 = findViewById(R.id.eveningCourse2);
        course11 = findViewById(R.id.eveningCourse3);
        course12 = findViewById(R.id.eveningCourse4);

        ArrayList<String> courses = new ArrayList<>();
        courses.add("Mathematics");
        courses.add("English");
        courses.add("Robotics");
        courses.add("Computer Science");
        courses.add("Chemistry");
        courses.add("Physics");
        courses.add("Physical Education");
        courses.add("Canadian Law");
        courses.add("Violin");

        ArrayAdapter<String> coursesAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, courses
        );

        morning1.setAdapter(coursesAdapter);
        morning2.setAdapter(coursesAdapter);
        morning3.setAdapter(coursesAdapter);
        morning4.setAdapter(coursesAdapter);

        afternoon1.setAdapter(coursesAdapter);
        afternoon2.setAdapter(coursesAdapter);
        afternoon3.setAdapter(coursesAdapter);
        afternoon4.setAdapter(coursesAdapter);

        // Change the Button Text Based on User Choice
        morning1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(School_Schedule.this, courses.get(position), Toast.LENGTH_SHORT).show();
                String course = courses.get(position);
                course1.setText(course);
            }
        });

        morning2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(School_Schedule.this, courses.get(position), Toast.LENGTH_SHORT).show();
                String course = courses.get(position);
                course2.setText(course);
            }
        });

        morning3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(School_Schedule.this, courses.get(position), Toast.LENGTH_SHORT).show();
                String course = courses.get(position);
                course3.setText(course);
            }
        });

        morning4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(School_Schedule.this, courses.get(position), Toast.LENGTH_SHORT).show();
                String course = courses.get(position);
                course4.setText(course);
            }
        });

        // TODO: add remaining button functionality
    }

    // This function brings the user to the "Morning Section" of the App when the user clicks on the Morning button in the schedule
    public void onMorningClick(View view) {
        Toast.makeText(School_Schedule.this, "Good Morning!", Toast.LENGTH_SHORT).show();

        NavController activityToMorning = Navigation.findNavController(School_Schedule.this,
                R.id.action_school_Schedule_to_morning_Fragment);
        activityToMorning.navigate(R.id.action_school_Schedule_to_morning_Fragment);
    }

    // This function brings the user to the "Afternoon Section" of the App when the user clicks on the Afternoon button in the schedule
    public void onAfternoonClick(View view) {
        Toast.makeText(School_Schedule.this, "Good Afternoon!", Toast.LENGTH_SHORT).show();

        NavController activityToAfternoon = Navigation.findNavController(School_Schedule.this,
                    R.id.action_school_Schedule_to_afternoon_Fragment);
        activityToAfternoon.navigateUp();
        activityToAfternoon.navigate(R.id.action_school_Schedule_to_afternoon_Fragment);
    }

    // This function brings the user to the "Evening Section" of the App when the user clicks on the Evening button in the schedule
    public void onEveningClick(View view) {
        Toast.makeText(School_Schedule.this, "Good Evening!", Toast.LENGTH_SHORT).show();

        // action_school_Schedule_to_evening_Fragment

        NavController activityToEvening = Navigation.findNavController(School_Schedule.this,
                R.id.action_school_Schedule_to_evening_Fragment);
        activityToEvening.navigateUp();
        activityToEvening.navigate(R.id.action_school_Schedule_to_evening_Fragment);
    }

}