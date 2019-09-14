package com.example.featembertransition;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class fragment3 extends Fragment {

 public FragmentActivity fragmentcontext;
static List<Bubble> bbl=new ArrayList<>();
Thread thread;
cokedownview mmview;
    public fragment3() {
        // Required empty public constructor
    }


    public static fragment3 newInstance() {
        fragment3 fragment = new fragment3();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mmview=container.findViewById(R.id.downviewer);

        thread=new Thread(mmview);
        thread.start();
        return inflater.inflate(R.layout.fragment_fragment3, container, false);
    }


    @Override
    public void onAttach(Context context) {
        fragmentcontext=(FragmentActivity)context;
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    public static float generateRandom(float x, float y) {
        return (float) Math.random() * (y - x) + x;
    }
    public static void  generateBubble()
    {
fragment2.bbl.add(new Bubble(
                generateRandom(0, 1080),
                2160,
                generateRandom(4, 5),
                generateRandom(0.01f, 1f),
                generateRandom(0.1f, 0.3f),
                0.5f
        ));
    }
    public FragmentActivity getFragcontext(){
        if (fragmentcontext!=null){
            return fragmentcontext;
        }

        return null;



    }

}
