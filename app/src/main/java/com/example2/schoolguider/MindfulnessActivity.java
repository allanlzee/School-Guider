package com.example2.schoolguider;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example2.schoolguider.ui.main.ui.main.SectionsPagerAdapter;

public class MindfulnessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mindfulness);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /* Fragment reading = new Fragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.mainLayout, reading).commit(); */
    }

    public void onMeditationClick(View view) {
        NavController activityToMeditation = Navigation.findNavController(MindfulnessActivity.this,
                R.id.action_mindfulnessActivity_to_mindfulnessFragment1);
        activityToMeditation.navigateUp();
        activityToMeditation.navigate(R.id.action_mindfulnessActivity_to_mindfulnessFragment1);
    }

    public void onMusicClick(View view) {
        NavController activityToMusic =  Navigation.findNavController(MindfulnessActivity.this,
                R.id.action_mindfulnessActivity_to_music_Mindfulness);
        activityToMusic.navigateUp();
        activityToMusic.navigate(R.id.action_mindfulnessActivity_to_music_Mindfulness);
    }

    public void onReadingClick(View view) {
        NavController activityToReading =  Navigation.findNavController(MindfulnessActivity.this,
                // TODO: add reading fragments
                R.id.action_mindfulnessActivity_to_mindfulness_Reading);
        activityToReading.navigateUp();
        activityToReading.navigate(R.id.action_mindfulnessActivity_to_mindfulness_Reading);
    }
}