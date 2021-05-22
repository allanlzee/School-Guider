package com.example2.schoolguider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Grades_Overview extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.grades_overview, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.backToActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Grades_Overview.this)
                        .navigate(R.id.action_goals_Overview_to_goals_Fragment);
            }
        });

        FloatingActionButton backToHome = view.findViewById(R.id.backToHome);
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(Grades_Overview.this)
                        .navigate(R.id.action_grades_Overview_to_gradesFragment);
            }
        });

        FloatingActionButton toAlarm = view.findViewById(R.id.buttonToAlarm);
        toAlarm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent alarm = new Intent(getActivity(), DailyNotification.class);
                startActivity(alarm);
                ((Activity) getActivity()).overridePendingTransition(0, 0);
            }
        });

        // Set Navigation for the Buttons
        Button achievement = view.findViewById(R.id.achievements);
        Button goals = view.findViewById(R.id.goals);
        Button next = view.findViewById(R.id.nextSteps);
        Button advice = view.findViewById(R.id.advice);
        Button schedule = view.findViewById(R.id.schedule);

        achievement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // action_grades_Overview_to_achievements_Fragment
                NavHostFragment.findNavController(Grades_Overview.this)
                        .navigate(R.id.action_grades_Overview_to_achievements_Fragment);
            }
        });

        goals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Grades_Overview.this)
                        .navigate(R.id.action_grades_Overview_to_goals_Fragment);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Grades_Overview.this)
                        .navigate(R.id.action_grades_Overview_to_goals_Overview);
            }
        });

        advice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(Grades_Overview.this)
                        .navigate(R.id.action_grades_Overview_to_achievements_Fragment);
                // TODO: change this action ID
            }
        });

        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSchedule = new Intent(getActivity(), DailyNotification.class);
                startActivity(toSchedule);
                ((Activity) getActivity()).overridePendingTransition(0, 0);
            }
        });
    }
}