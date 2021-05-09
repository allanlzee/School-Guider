package com.example2.schoolguider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class GradesFragment extends Fragment {

    private Spinner course1;
    private Spinner course2;
    private Spinner course3;
    private Spinner course4;

    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.grades_fragment, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(GradesFragment.this)
                        .navigate(R.id.action_gradesFragment_to_grades_Overview);
            }
        });



    }
}