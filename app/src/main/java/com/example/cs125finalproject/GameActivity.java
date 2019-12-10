package com.example.cs125finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import java.io.IOException;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            playMusic();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setContentView(R.layout.activity_game);
        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button10 = findViewById(R.id.button10);
        Button button11 = findViewById(R.id.button11);
        Button button12 = findViewById(R.id.button12);
        Button button13 = findViewById(R.id.button13);
        Button button14 = findViewById(R.id.button14);
        Button button15 = findViewById(R.id.button15);
        Button button16 = findViewById(R.id.button16);
        Button button17 = findViewById(R.id.button17);
        Button button18 = findViewById(R.id.button18);
        Button button19 = findViewById(R.id.button19);
        Button button20 = findViewById(R.id.button20);
        Button button21 = findViewById(R.id.button21);
        Button button22 = findViewById(R.id.button22);
        Button button23 = findViewById(R.id.button23);
        Button button24 = findViewById(R.id.button24);
        Button button25 = findViewById(R.id.button25);
        button1.setOnClickListener(unused -> button1.setText("1"));
        button2.setOnClickListener(unused -> button2.setText("1"));
        button3.setOnClickListener(unused -> button3.setText("1"));
        button4.setOnClickListener(unused -> button4.setText("1"));
        button5.setOnClickListener(unused -> button5.setText("1"));
        button6.setOnClickListener(unused -> button6.setText("1"));
        button7.setOnClickListener(unused -> button7.setText("1"));
        button8.setOnClickListener(unused -> button8.setText("1"));
        button9.setOnClickListener(unused -> button9.setText("1"));
        button10.setOnClickListener(unused -> button10.setText("1"));
        button11.setOnClickListener(unused -> button11.setText("1"));
        button12.setOnClickListener(unused -> button12.setText("1"));
        button13.setOnClickListener(unused -> button13.setText("1"));
        button14.setOnClickListener(unused -> button14.setText("1"));
        button15.setOnClickListener(unused -> button15.setText("1"));
        button16.setOnClickListener(unused -> button16.setText("1"));
        button17.setOnClickListener(unused -> button17.setText("1"));
        button18.setOnClickListener(unused -> button18.setText("1"));
        button19.setOnClickListener(unused -> button19.setText("1"));
        button20.setOnClickListener(unused -> button20.setText("1"));
        button21.setOnClickListener(unused -> button21.setText("1"));
        button22.setOnClickListener(unused -> button22.setText("1"));
        button23.setOnClickListener(unused -> button23.setText("1"));
        button24.setOnClickListener(unused -> button24.setText("1"));
        button25.setOnClickListener(unused -> button25.setText("1"));
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
