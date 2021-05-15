package com.example2.schoolguider;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;

import android.view.View;
import android.widget.Button;

public class EveningActivitiesPage extends AppCompatActivity {

    private Button codingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evening_activities_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        codingButton = findViewById(R.id.codingButton);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Go to Home", Snackbar.LENGTH_LONG)
                        .setAction("Continue", new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(EveningActivitiesPage.this, MainActivity.class));
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.eveningButton))
                        .setTextColor(getResources().getColor(R.color.achievements))
                        .show();
            }
        });

        codingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(EveningActivitiesPage.this, R.id.action_eveningActivitiesPage_to_codingFragment);
                controller.navigate(R.id.action_eveningActivitiesPage_to_codingFragment);
            }
        });
    }
}