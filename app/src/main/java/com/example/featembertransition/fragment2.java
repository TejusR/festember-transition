package com.example.featembertransition;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class fragment2 extends Fragment {
    int ARRAY_LENGTH=50;
    public static List<Bubble> bbl;
    private  Thread thread;
    DrawWave drawWave;
    static MediaPlayer mp;
    static boolean done=false;
    public FragmentActivity fragcontext;






    public fragment2() {
        // Required empty public constructor
    }


    public static fragment2 newInstance() {
        fragment2 fragment = new fragment2();
      return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("<<<<<<<<<<","");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(">>>>>>>>>>>>>","");

        drawWave=container.findViewById(R.id.drawing);
        bbl = new ArrayList<Bubble>();
        mp = new MediaPlayer();
        mp = MediaPlayer.create(getActivity(), R.raw.pouring_sound);

        thread=new Thread(drawWave);
        mp.start();
        thread.start();

        return inflater.inflate(R.layout.fragment_fragment2, container, false);
    }


    @Override
    public void onAttach(Context context) {
        fragcontext=(FragmentActivity)context;

        super.onAttach(context);
    }


    @Override
    public void onDetach() {
        super.onDetach();

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

public FragmentActivity getFragcontext(){
        if (fragcontext!=null){
            return fragcontext;
        }

            return null;



}

}
