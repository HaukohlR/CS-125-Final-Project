package com.example.cs125finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;


public class GameActivity extends AppCompatActivity {
    private int[][] grid;
    private int[] buttonNums;
    private boolean[] clicked;
    private int totalPoints;
    private int roundPoints;
    private int level;
    private BackendImplementation helper;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    Button button11;
    Button button12;
    Button button13;
    Button button14;
    Button button15;
    Button button16;
    Button button17;
    Button button18;
    Button button19;
    Button button20;
    Button button21;
    Button button22;
    Button button23;
    Button button24;
    Button button25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        level = 1;
        helper = new BackendImplementation();
        newRound();

        try {
            playMusic();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setContentView(R.layout.activity_game);
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button13 = findViewById(R.id.button13);
        button14 = findViewById(R.id.button14);
        button15 = findViewById(R.id.button15);
        button16 = findViewById(R.id.button16);
        button17 = findViewById(R.id.button17);
        button18 = findViewById(R.id.button18);
        button19 = findViewById(R.id.button19);
        button20 = findViewById(R.id.button20);
        button21 = findViewById(R.id.button21);
        button22 = findViewById(R.id.button22);
        button23 = findViewById(R.id.button23);
        button24 = findViewById(R.id.button24);
        button25 = findViewById(R.id.button25);

        TextView column1 = findViewById(R.id.textView2);
        TextView column2 = findViewById(R.id.textView8);
        TextView column3 = findViewById(R.id.textView4);
        TextView column4 = findViewById(R.id.textView5);
        TextView column5 = findViewById(R.id.textView6);
        TextView row1 = findViewById(R.id.textView7);
        TextView row2 = findViewById(R.id.textView9);
        TextView row3 = findViewById(R.id.textView10);
        TextView row4 = findViewById(R.id.textView11);
        TextView row5 = findViewById(R.id.textView12);


        button1.setOnClickListener(unused -> button1.setText(buttonClick(1)));
        button2.setOnClickListener(unused -> button1.setText(buttonClick(2)));
        button3.setOnClickListener(unused -> button1.setText(buttonClick(3)));
        button4.setOnClickListener(unused -> button1.setText(buttonClick(4)));
        button5.setOnClickListener(unused -> button1.setText(buttonClick(5)));
        button6.setOnClickListener(unused -> button1.setText(buttonClick(6)));
        button7.setOnClickListener(unused -> button1.setText(buttonClick(7)));
        button8.setOnClickListener(unused -> button1.setText(buttonClick(8)));
        button9.setOnClickListener(unused -> button1.setText(buttonClick(9)));
        button10.setOnClickListener(unused -> button1.setText(buttonClick(10)));
        button11.setOnClickListener(unused -> button1.setText(buttonClick(11)));
        button12.setOnClickListener(unused -> button1.setText(buttonClick(12)));
        button13.setOnClickListener(unused -> button1.setText(buttonClick(13)));
        button14.setOnClickListener(unused -> button1.setText(buttonClick(14)));
        button15.setOnClickListener(unused -> button1.setText(buttonClick(15)));
        button16.setOnClickListener(unused -> button1.setText(buttonClick(16)));
        button17.setOnClickListener(unused -> button1.setText(buttonClick(17)));
        button18.setOnClickListener(unused -> button1.setText(buttonClick(18)));
        button19.setOnClickListener(unused -> button1.setText(buttonClick(19)));
        button20.setOnClickListener(unused -> button1.setText(buttonClick(20)));
        button21.setOnClickListener(unused -> button1.setText(buttonClick(21)));
        button22.setOnClickListener(unused -> button1.setText(buttonClick(22)));
        button23.setOnClickListener(unused -> button1.setText(buttonClick(23)));
        button24.setOnClickListener(unused -> button1.setText(buttonClick(24)));
        button25.setOnClickListener(unused -> button1.setText(buttonClick(25)));
    }
    public String buttonClick(int buttonNumber) {
        if (!clicked[buttonNumber]) {
            roundPoints *= buttonNums[buttonNumber];
            if (buttonNums[buttonNumber] == 0) {
                gameOver();
            }
        }
        clicked[buttonNumber] = false;
        if (completeGrid()) {
            level++;
            newRound();
        }
        return buttonNums[buttonNumber] + "";
    }
    private void newRound() {
        grid = helper.generateGrid(level);
        int count = 0;
        buttonNums = new int[25];
        clicked = new boolean[25];
        for (int k = 0; k < grid.length; k++) {
            for (int i = 0; i < grid[k].length; i++) {
                buttonNums[count] = grid[k][i];
                count++;
            }
        }
        for (int k = 0; k < clicked.length; k++) {
            clicked[k] = false;
        }
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
        button10.setText("");
        button11.setText("");
        button12.setText("");
        button13.setText("");
        button14.setText("");
        button15.setText("");
        button16.setText("");
        button17.setText("");
        button18.setText("");
        button19.setText("");
        button20.setText("");
        button21.setText("");
        button22.setText("");
        button23.setText("");
        button24.setText("");
        button25.setText("");
    }
    public boolean completeGrid() {
        for (int k = 0; k < buttonNums.length; k++) {
            if (buttonNums[k] > 1 && !clicked[k]) {
                return false;
            }
        }
        return true;
    }
    public void gameOver() {
        TextView gameOver = findViewById(R.id.gameOver);
        gameOver.setVisibility(View.VISIBLE);
        try {
            Thread.sleep(10000);
        } catch (Exception e){
            e.printStackTrace();
        }
        startActivity(new Intent(this, MainActivity.class));
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
