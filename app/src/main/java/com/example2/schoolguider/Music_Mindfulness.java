package com.example2.schoolguider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

class Music_Mindfulness extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.music_mindfulness_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FloatingActionButton home = view.findViewById(R.id.backToHome);
        FloatingActionButton toAlarm = view.findViewById(R.id.buttonAlarm);

        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent home = new Intent(getActivity(), MainActivity.class);
                startActivity(home);
                ((Activity) getActivity()).overridePendingTransition(0, 0);
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

    public void onBtnClick(View view) {
        // TODO: add functionality (right now the buttons do not do anything)
    }
}