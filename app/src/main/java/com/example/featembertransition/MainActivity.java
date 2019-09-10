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
    public static List<Bubble> bbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bbl=new ArrayList<Bubble>();
        MediaPlayer mp=new MediaPlayer();
        mp=MediaPlayer.create(getApplicationContext(),R.raw.pouring_sound);
        mp.start();
    }
    public static void generateBubble()
    {
        bbl.add(new Bubble(new Random().nextInt(1080),2160));
    }
}
