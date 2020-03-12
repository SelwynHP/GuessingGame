package com.artemis.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        int num = getIntent().getExtras().getInt("num");

        Random randomizer = new Random(num);
        final int ran = randomizer.nextInt(num);

        final Button buttonGuess = findViewById(R.id.buttonGuess);
        buttonGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textViewResult = findViewById(R.id.textViewResult);
                EditText editTextGuess = findViewById(R.id.editTextGuess);
                TextView textViewCounter = findViewById(R.id.textViewCounter);
                //==========Incrementing Counter==========
                int attempts = Integer.parseInt(textViewCounter.getText().toString());
                attempts += 1;
                textViewCounter.setText("" + attempts);
                //==========Processing Result==========
                String str = editTextGuess.getText().toString();
                int guess;
                if(str.isEmpty()){
                    guess = 0;
                }
                else{
                    guess = Integer.parseInt(str);
                }
                if(guess == ran){
                    textViewResult.setText("Success");
                    buttonGuess.setEnabled(false);
                }
                else if(guess > ran){
                    textViewResult.setText("Wrong!" + "Number is lower.");

                }
                else if(guess < ran){
                    textViewResult.setText("Wrong!" + "Number is higher.");
                }
            }
        });
    }
}
