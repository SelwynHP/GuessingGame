package com.artemis.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStart = findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextMaxRange = findViewById(R.id.editTextMaxRange);
                int max = Integer.parseInt(editTextMaxRange.getText().toString());
                Intent ActStart = new Intent(getApplicationContext(),Main2Activity.class);
                ActStart.putExtra("num",max);
                startActivity(ActStart);
            }
        });
    }
}
