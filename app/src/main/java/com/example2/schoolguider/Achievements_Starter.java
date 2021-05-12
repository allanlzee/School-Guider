package com.example2.schoolguider;

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onAchievementsClick(View view) {
        NavController navController = Navigation.findNavController(this, R.id.action_achievements_Starter_to_achievements_Overview);
        navController.navigate(R.id.action_achievements_Starter_to_achievements_Overview);
    }
}