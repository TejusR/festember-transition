package com.example.featembertransition;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int ARRAY_LENGTH=50;
    public static List<Bubble> bbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bbl = new ArrayList<Bubble>();
        MediaPlayer mp = new MediaPlayer();
        mp = MediaPlayer.create(getApplicationContext(), R.raw.pouring_sound);
        mp.start();
        //for(int i=0;i<ARRAY_LENGTH;i++)
    }


    public static float generateRandom(float x, float y) {
        return (float) Math.random() * (y - x) + x;
    }
    public static void generateBubble()
    {
        bbl.add(new Bubble(
                generateRandom(0, 1080),
                2160,
                generateRandom(4, 5),
                generateRandom(0.01f, 1f),
                generateRandom(0.1f, 0.3f),
                0.5f
        ));
    }
}
