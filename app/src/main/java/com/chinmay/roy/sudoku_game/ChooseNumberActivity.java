package com.chinmay.roy.sudoku_game;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;

/**
 * Developed by Chinmay Roy on 2023.
 */

public class ChooseNumberActivity extends AppCompatActivity {
    private int selectedNumber = 1;
    private boolean checkBoxChecked = false;
    private boolean newBoardCreating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_number);
        initializeSpinner();
        newBoardCreating = getIntent().getBooleanExtra("newBoard", false);
        if (newBoardCreating) {
            CheckBox checkBox = findViewById(R.id.checkBox);
            checkBox.setVisibility(View.INVISIBLE);
        }
    }

    private void initializeSpinner() {
        final Integer numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, numbers);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedNumber = numbers[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void onCheckBoxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        checkBoxChecked = view.getId() == R.id.checkBox && checked;
    }

    public void chooseNumberButtonClicked(View view) {
        Intent intent = new Intent();
        intent.putExtra("chosenNumber", selectedNumber);
        intent.putExtra("isUnsure", checkBoxChecked);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void onRemovePieceButtonClicked(View view) {
        Intent intent = new Intent();
        intent.putExtra("removePiece", true);
        setResult(RESULT_OK, intent);
        finish();
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
        Intent intent = new Intent(ChooseNumberActivity.this, InstructionsActivity.class);
        startActivity(intent);
    }

    public void openContactUsActivity(){
        Intent intent = new Intent(ChooseNumberActivity.this, ContactUsActivity.class);
        startActivity(intent);
    }

    public void openAboutDeveloperActivity(){
        Intent intent = new Intent(ChooseNumberActivity.this, AboutDeveloperActivity.class);
        startActivity(intent);
    }


    public void onGoBackButtonClicked(View view) {
        finish();
    }
}
