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
    private int roundPoints = 1;
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

    TextView rPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        level = 1;
        helper = new BackendImplementation();

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

        rPoints = findViewById(R.id.totalPnts);


        newRound();

        int[] colPoints = helper.calculatePointsColumns(grid);
        int[] colBombs = helper.calculateBombsColumns(grid);
        int[] rowPoints = helper.calculatePointsRows(grid);
        int[] rowBombs = helper.calculateBombsRows(grid);

        column1.setText(String.valueOf(colPoints[0]) + "-" + String.valueOf(colBombs[0]));
        column2.setText(String.valueOf(colPoints[1]) + "-" + String.valueOf(colBombs[1]));
        column3.setText(String.valueOf(colPoints[2]) + "-" + String.valueOf(colBombs[2]));
        column4.setText(String.valueOf(colPoints[3]) + "-" + String.valueOf(colBombs[3]));
        column5.setText(String.valueOf(colPoints[4]) + "-" + String.valueOf(colBombs[4]));

        row1.setText(String.valueOf(rowPoints[0]) + "-" + String.valueOf(rowBombs[0]));
        row2.setText(String.valueOf(rowPoints[1]) + "-" + String.valueOf(rowBombs[1]));
        row3.setText(String.valueOf(rowPoints[2]) + "-" + String.valueOf(rowBombs[2]));
        row4.setText(String.valueOf(rowPoints[3]) + "-" + String.valueOf(rowBombs[3]));
        row5.setText(String.valueOf(rowPoints[4]) + "-" + String.valueOf(rowBombs[4]));



        button1.setOnClickListener(unused -> button1.setText(buttonClick(1)));
        button2.setOnClickListener(unused -> button2.setText(buttonClick(2)));
        button3.setOnClickListener(unused -> button3.setText(buttonClick(3)));
        button4.setOnClickListener(unused -> button4.setText(buttonClick(4)));
        button5.setOnClickListener(unused -> button5.setText(buttonClick(5)));
        button6.setOnClickListener(unused -> button6.setText(buttonClick(6)));
        button7.setOnClickListener(unused -> button7.setText(buttonClick(7)));
        button8.setOnClickListener(unused -> button8.setText(buttonClick(8)));
        button9.setOnClickListener(unused -> button9.setText(buttonClick(9)));
        button10.setOnClickListener(unused -> button10.setText(buttonClick(10)));
        button11.setOnClickListener(unused -> button11.setText(buttonClick(11)));
        button12.setOnClickListener(unused -> button12.setText(buttonClick(12)));
        button13.setOnClickListener(unused -> button13.setText(buttonClick(13)));
        button14.setOnClickListener(unused -> button14.setText(buttonClick(14)));
        button15.setOnClickListener(unused -> button15.setText(buttonClick(15)));
        button16.setOnClickListener(unused -> button16.setText(buttonClick(16)));
        button17.setOnClickListener(unused -> button17.setText(buttonClick(17)));
        button18.setOnClickListener(unused -> button18.setText(buttonClick(18)));
        button19.setOnClickListener(unused -> button19.setText(buttonClick(19)));
        button20.setOnClickListener(unused -> button20.setText(buttonClick(20)));
        button21.setOnClickListener(unused -> button21.setText(buttonClick(21)));
        button22.setOnClickListener(unused -> button22.setText(buttonClick(22)));
        button23.setOnClickListener(unused -> button23.setText(buttonClick(23)));
        button24.setOnClickListener(unused -> button24.setText(buttonClick(24)));
        button25.setOnClickListener(unused -> button25.setText(buttonClick(25)));
    }
    public String buttonClick(int buttonNumber) {
        if (!clicked[buttonNumber]) {
            roundPoints *= buttonNums[buttonNumber];
            rPoints.setText(String.valueOf(roundPoints));
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
 /*       try {
            Thread.sleep(10000);
        } catch (Exception e){
            e.printStackTrace();
        }

  */
        TextView back = findViewById(R.id.textView3);
        back.setVisibility(View.VISIBLE);
    }
}
