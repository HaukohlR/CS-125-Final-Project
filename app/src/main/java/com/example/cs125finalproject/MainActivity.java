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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            playMusic();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Button createGame = findViewById(R.id.newGameButton);
        createGame.setOnClickListener(unused -> startActivity(new Intent(this, GameActivity.class)));

        Button tutorial = findViewById(R.id.how2playbutton);
        tutorial.setOnClickListener(unused -> startActivity(new Intent(this, TutorialActivity.class)));
    }
    public void playMusic() throws IOException {
        String url = "http://www.youtube.com/watch?v=cpYjrr-SZuI";
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
        } catch (IOException e) {
            try {
                throw new IOException();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        mediaPlayer.prepare();
        mediaPlayer.start();
    }
}
