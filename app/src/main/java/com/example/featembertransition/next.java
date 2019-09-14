package com.example.featembertransition;

import android.app.Activity;
import android.os.Bundle;


public class next extends Activity {
    cokedownview mview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_next);

        mview=findViewById(R.id.downviewer);



        Thread thread=new Thread(mview);

        thread.start();

    }




}

