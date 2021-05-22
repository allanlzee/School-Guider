package com.example2.schoolguider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Achievements_Overview extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.achievements_overview, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.backToActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Achievements_Overview.this)
                        .navigate(R.id.action_achievements_Overview_to_achievements_Fragment);
            }
        });

        FloatingActionButton backToHome = view.findViewById(R.id.backToHome);
        FloatingActionButton toAlarm = view.findViewById(R.id.buttonAlarm);
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(Achievements_Overview.this)
                        .navigate(R.id.action_achievements_Overview_to_achievements_Starter);
            }
        });

        toAlarm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent alarm = new Intent(getActivity(), DailyNotification.class);
                startActivity(alarm);
                ((Activity) getActivity()).overridePendingTransition(0, 0);
            }
        });
    }
}