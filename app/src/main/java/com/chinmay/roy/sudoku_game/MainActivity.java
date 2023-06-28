package com.chinmay.roy.sudoku_game;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refreshButtonAction();
    }

    private void refreshButtonAction() {
        Log.i(TAG, "Refreshing View Languages");
        Button buttonStartNewGame = findViewById(R.id.buttonStartNewGame);
        buttonStartNewGame.setText(R.string.new_game);
        Button buttonAddNewBoard = findViewById(R.id.buttonAddNewBoard);
        buttonAddNewBoard.setText(R.string.add_new_board);
    }

    public void onStartNewGameButtonClicked(View view) {
        Intent intent = new Intent("com.chinmay.roy.GameDifficultyActivity");
        startActivity(intent);
    }

    public void onAddNewBoardButtonClicked(View view) {
        Intent intent = new Intent("com.chinmay.roy.NewBoardActivity");
        startActivity(intent);
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
        Intent intent = new Intent(MainActivity.this, InstructionsActivity.class);
        startActivity(intent);
    }

    public void openContactUsActivity(){
        Intent intent = new Intent(MainActivity.this, ContactUsActivity.class);
        startActivity(intent);
    }

    public void openAboutDeveloperActivity(){
        Intent intent = new Intent(MainActivity.this, AboutDeveloperActivity.class);
        startActivity(intent);
    }

}
