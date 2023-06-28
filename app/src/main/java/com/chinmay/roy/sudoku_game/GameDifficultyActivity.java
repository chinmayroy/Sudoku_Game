package com.chinmay.roy.sudoku_game;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

/**
 * Developed by Chinmay Roy on 2023.
 */

public class GameDifficultyActivity extends AppCompatActivity {
    private boolean newBoard = false;
    private int selectedDifficulty = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_difficulty);
        newBoard = getIntent().getBooleanExtra("newBoard", false);
        if (newBoard) {
            Button buttonContinue = findViewById(R.id.buttonContinue);
            buttonContinue.setText(getString(R.string.add_new_board));
        }
    }

    public void onGoBackButtonClicked(View view) {
        finish();
    }

    @SuppressLint("NonConstantResourceId")
    public void onDifficultyRadioButtonsClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioButtonEasy:
                if (checked) {
                    selectedDifficulty = 0;
                }
                break;
            case R.id.radioButtonNormal:
                if (checked) {
                    selectedDifficulty = 1;
                }
                break;
            case R.id.radioButtonHard:
                if (checked) {
                    selectedDifficulty = 2;
                }
                break;
        }
    }

    public void onStartGameButtonClicked(View view) {
        if (newBoard) {
            Intent intent = new Intent();
            intent.putExtra("boardSaved", true);
            intent.putExtra("difficulty", selectedDifficulty);
            setResult(RESULT_OK, intent);
            finish();
        } else {
            Intent intent = new Intent("com.chinmay.roy.GameActivity");
            intent.putExtra("difficulty", selectedDifficulty);
            startActivity(intent);
        }
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
        Intent intent = new Intent(GameDifficultyActivity.this, InstructionsActivity.class);
        startActivity(intent);
    }

    public void openContactUsActivity(){
        Intent intent = new Intent(GameDifficultyActivity.this, ContactUsActivity.class);
        startActivity(intent);
    }

    public void openAboutDeveloperActivity(){
        Intent intent = new Intent(GameDifficultyActivity.this, AboutDeveloperActivity.class);
        startActivity(intent);
    }
}
