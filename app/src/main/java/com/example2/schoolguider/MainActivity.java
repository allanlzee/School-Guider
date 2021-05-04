package com.example2.schoolguider;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavHost;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.nav_home:
                Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                return true;
            case R.id.nav_school:
                Toast.makeText(MainActivity.this, "School", Toast.LENGTH_SHORT).show();
                // Bring User to School Pages
                startActivity(new Intent(MainActivity.this, School_Page.class));
                return true;
            case R.id.nav_schedule:
                Toast.makeText(MainActivity.this, "Schedule", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, School_Schedule.class));
                return true;
            case R.id.nav_mindfulness:
                Toast.makeText(MainActivity.this, "Mindfulness", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, MindfulnessActivity.class));
                return true;
            case R.id.nav_Morning:
                Toast.makeText(MainActivity.this, "Good Morning " + userName + "!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, MorningActivitiesPage.class));
                return true;
            case R.id.nav_Afternoon:
                Toast.makeText(MainActivity.this, "Good Afternoon " + userName + "!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, AfternoonActivitiesPage.class));
                return true;
            case R.id.nav_Evening:
                Toast.makeText(MainActivity.this, "Good Evening " + userName + "!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, EveningActivitesPage.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onBtnClick(View view) {
        TextView greetingMsg = findViewById(R.id.greetingMsg);
        EditText inputName = findViewById(R.id.inputName);
        greetingMsg.setText("Greetings " + inputName.getText().toString());
        userName = inputName.getText().toString();
    }
}