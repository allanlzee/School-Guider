package com.example2.schoolguider;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

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
            case R.id.settings_menu:
                Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                return true;
            case R.id.school_menu:
                Toast.makeText(MainActivity.this, "School", Toast.LENGTH_SHORT).show();
                // Bring User to School Pages
                startActivity(new Intent(MainActivity.this, School_Page.class));
                return true;
            case R.id.schedule_menu:
                Toast.makeText(MainActivity.this, "Schedule", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, School_Schedule.class));
                return true;
            case R.id.mindful_menu:
                Toast.makeText(MainActivity.this, "Mindfulness", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, MindfulnessActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onBtnClick(View view) {
        TextView greetingMsg = findViewById(R.id.greetingMsg);
        EditText inputName = findViewById(R.id.inputName);
        greetingMsg.setText("Greetings " + inputName.getText().toString());
    }
}