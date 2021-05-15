package com.example2.schoolguider;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;

import com.example2.schoolguider.databinding.CourseGradesBinding;

public class Course_Grades extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private CourseGradesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = CourseGradesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Back to Home", Snackbar.LENGTH_LONG)
                        .setAction("Continue", new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Course_Grades.this, MainActivity.class));
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.goalsButton))
                        .setTextColor(getResources().getColor(R.color.teal_200))
                        .show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        startActivity(new Intent(Course_Grades.this, GradesInput.class));
        return true;
    }

    public void onOutlineClick(View view) {
        startActivity(new Intent(Course_Grades.this, GradesInput.class));
    }
}