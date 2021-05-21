package com.example2.schoolguider;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example2.schoolguider.databinding.GoalsStarterBinding;

public class Goals_Starter extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private GoalsStarterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = GoalsStarterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_goals_starter);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Back to Home", Snackbar.LENGTH_LONG)
                        .setAction("Continue", new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Goals_Starter.this, MainActivity.class));
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.schedule))
                        .setTextColor(getResources().getColor(R.color.orange))
                        .show();
            }
        });

        binding.buttonToAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Go to Alarm", Snackbar.LENGTH_LONG)
                        .setAction("Go", new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Goals_Starter.this, DailyNotification.class));
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.teal_200))
                        .setTextColor(getResources().getColor(R.color.afternoon))
                        .show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_goals_starter);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void onGoalsClick(View view) {
        NavController activityToFragment = Navigation.findNavController(this, R.id.action_goals_Starter_to_goals_Fragment);
        activityToFragment.navigate(R.id.action_goals_Starter_to_goals_Fragment);
    }
}