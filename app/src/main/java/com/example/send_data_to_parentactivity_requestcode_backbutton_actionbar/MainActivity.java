package com.example.send_data_to_parentactivity_requestcode_backbutton_actionbar;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public static final int NAME_REQUEST_CODE = 1001;
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    private TextView firstName,lastName,implicitText;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.firstName_tv);
        lastName = findViewById(R.id.lastName_tv);
        implicitText = findViewById(R.id.implicit_text_receiver);

        button = findViewById(R.id.button_toActivity2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Activity_2.class);
                startActivityForResult(intent,NAME_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        if (intent != null) {
            String message =  intent.getStringExtra("IMPLICIT_TEXT");
            if (message != null) {
                implicitText.setText(message);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NAME_REQUEST_CODE && resultCode == RESULT_OK){
            String firstNameText = data.getStringExtra(FIRST_NAME);
            String lastNameText = data.getStringExtra(LAST_NAME);

      //      Toast.makeText(getApplicationContext(),firstNameText+""+lastNameText,Toast.LENGTH_SHORT).show();

            firstName.setText(firstNameText);
            lastName.setText(lastNameText);
        }
    }
}
