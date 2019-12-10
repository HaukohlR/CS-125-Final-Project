package com.example.cs125finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class TutorialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        TextView text = findViewById(R.id.how_to_play);
        text.setText("This is how you play the game. Every square has a number from 0-3 inside it." +
                "Your point total starts at 0 and the first number you flip is added to it. All following" +
                "numbers are multiplied to your score. This means that any 0's that you flip result in a " +
                "game over. Once all numbers greater than 1 are flipped, you will continue to the next " +
                "level. The first number by a row or column indicate the total number of points in " +
                "that respective row or column The second number represents the amount of bombs.");

        Button back = findViewById(R.id.MainMenu);
        back.setOnClickListener(unused -> startActivity(new Intent(this, MainActivity.class)));
    }
}
