package com.example.featembertransition;



import android.app.Activity;

import android.media.MediaPlayer;

import android.os.Bundle;



import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int ARRAY_LENGTH=50;
    public static List<Bubble> bbl;
 static  Thread thread;
DrawWave drawWave;
    static MediaPlayer mp;
    static boolean done=false;

 public static fragment2 frag;
        static FragmentManager fm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);
    getSupportActionBar().hide();

         frag= new fragment2();
         fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
ft.replace(R.id.mainactivity,frag);
        ft.commit();





/*
        drawWave=findViewById(R.id.drawing);
        bbl = new ArrayList<Bubble>();
         mp = new MediaPlayer();
        mp = MediaPlayer.create(getApplicationContext(), R.raw.pouring_sound);
        thread=new Thread(drawWave);
        mp.start();
        thread.start();
        */



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
