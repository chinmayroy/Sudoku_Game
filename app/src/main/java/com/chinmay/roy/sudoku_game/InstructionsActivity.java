package com.chinmay.roy.sudoku_game;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.Locale;

/**
 * Developed by Chinmay Roy on 2023.
 */

public class InstructionsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        Locale locale = getResources().getConfiguration().locale;
        System.out.println(locale);

        Resources res = getBaseContext().getResources();
        res.updateConfiguration(new Configuration(), res.getDisplayMetrics());

        locale = getResources().getConfiguration().locale;
        System.out.println(locale);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_guidelines){
            openInstructionsActivity();
            return true;
        } else if(id == R.id.action_contact_us){
            openContactUsActivity();
            return true;
        } else if(id == R.id.action_about_developer){
            openAboutDeveloperActivity();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openInstructionsActivity(){
        Intent intent = new Intent(InstructionsActivity.this, InstructionsActivity.class);
        startActivity(intent);
    }

    public void openContactUsActivity(){
        Intent intent = new Intent(InstructionsActivity.this, ContactUsActivity.class);
        startActivity(intent);
    }

    public void openAboutDeveloperActivity(){
        Intent intent = new Intent(InstructionsActivity.this, AboutDeveloperActivity.class);
        startActivity(intent);
    }

    public void onGoBackButtonClicked(View view) {
        finish();
    }
}
