package com.example.send_data_to_parentactivity_requestcode_backbutton_actionbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

public class Activity_2 extends AppCompatActivity {

    private EditText firstName_et,lastName_et;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        firstName_et = findViewById(R.id.firstName);
        lastName_et =  findViewById(R.id.lastName);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_done_black_24dp);
    }

    @Override
    public void onBackPressed() {
        String firstName = firstName_et.getText().toString();
        String lastName = lastName_et.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(MainActivity.FIRST_NAME,firstName);
        intent.putExtra(MainActivity.LAST_NAME,lastName);
        setResult(RESULT_OK,intent);
        finish();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
