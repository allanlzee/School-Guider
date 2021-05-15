package com.example2.schoolguider;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.View;

public class AfternoonActivitiesPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afternoon_activities_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Back to Home", Snackbar.LENGTH_LONG)
                        .setAction("Continue", new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(AfternoonActivitiesPage.this, MainActivity.class));
                            }
                        }).show();
            }
        });
    }

    public void onCodingClick(View view) {
        NavController controller = Navigation.findNavController(AfternoonActivitiesPage.this, R.id.action_afternoonActivitiesPage_to_codingFragment);
        controller.navigate(R.id.action_afternoonActivitiesPage_to_codingFragment);
    }
}