package com.example.cs125finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import java.io.IOException;
import java.nio.channels.IllegalChannelGroupException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (mp == null) {
            mp = MediaPlayer.create(this, R.raw.song);
        }
        if (mp.isPlaying() == false) {
            mp.start();
        }


        Button createGame = findViewById(R.id.newGameButton);
        createGame.setOnClickListener(unused -> startActivity(new Intent(this, GameActivity.class)));

        Button tutorial = findViewById(R.id.how2playbutton);
        tutorial.setOnClickListener(unused -> startActivity(new Intent(this, TutorialActivity.class)));
    }

}
