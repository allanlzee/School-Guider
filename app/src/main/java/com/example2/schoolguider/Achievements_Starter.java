package com.example2.schoolguider;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import com.example2.schoolguider.databinding.AchievementsStarterBinding;

public class Achievements_Starter extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private AchievementsStarterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = AchievementsStarterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Back to Home", Snackbar.LENGTH_LONG)
                        .setAction("Continue", new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Achievements_Starter.this, MainActivity.class));
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.light_blue_600))
                        .setTextColor(getResources().getColor(R.color.goalsButton))
                        .show();
            }
        });
    }

    public void onAchievementsClick(View view) {
        NavController navController = Navigation.findNavController(this, R.id.action_achievements_Starter_to_achievements_Overview);
        navController.navigate(R.id.action_achievements_Starter_to_achievements_Overview);
    }
}