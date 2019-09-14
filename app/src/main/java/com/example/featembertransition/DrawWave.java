package com.example.featembertransition;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class DrawWave extends View implements  Runnable {
    Paint p, p1;
    Path path, mpath;
    float vx = 0;
    float vy = 2160;
    int count = 0;
    private Context mcontext;
    int height = Resources.getSystem().getDisplayMetrics().heightPixels;
    int width = Resources.getSystem().getDisplayMetrics().widthPixels;
    List<Bubble> bbl;
    fragment3 fragmen=fragment3.newInstance();


    public DrawWave(Context context) {

        super(context);
        this.mcontext = context;

    }

    public DrawWave(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mcontext = context;
    }

    public DrawWave(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mcontext = context;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DrawWave(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        Log.d("LLLLLLLLLLLL", String.valueOf(height));

        Log.d("!!!!!!!!!!!", String.valueOf(Thread.currentThread()));
        p = new Paint();
        p1 = new Paint();
        p.setColor(Color.parseColor("#652121"));

        //  p1.setColor(Color.parseColor("#412E15")); //not used

        p.setStyle(Paint.Style.FILL_AND_STROKE);

        //   p1.setStyle(Paint.Style.FILL_AND_STROKE); // not in use


        if (vy < -200) {
            reset();
        }

        createPath();


        if (count % 2 == 0) {
            fragment2.generateBubble();
        }

        count++;
        // canvas.drawPath(mpath,p1);
        canvas.drawPath(path, p);
        vx += 0.2;
        vy -= 15;
        for (int i = 0; i < fragment2.bbl.size(); i++) {
            fragment2.bbl.get(i).positionUpdate();

            if (fragment2.bbl.get(i).getY() > vy - (50 * Math.sin(fragment2.bbl.get(i).getX() * 2 * Math.PI / 1080 + Math.PI))) {
                Drawable d = getResources().getDrawable(R.drawable.bubble_filter);
                d.setBounds((int) fragment2.bbl.get(i).getX(), (int) fragment2.bbl.get(i).getY(), (int) fragment2.bbl.get(i).getX() + (int) fragment2.bbl.get(i).size, (int) fragment2.bbl.get(i).getY() + (int) fragment2.bbl.get(i).size);
                d.draw(canvas);
            }


        }
        invalidate();
    }

    public void createPath() {
        path = new Path();
        //  mpath=new Path();
        path.reset();
        // mpath.reset();
        path.moveTo(0, 2160);
        for (int i = 0; i < 1080; i++) {
            path.lineTo(i, 2160);
            // mpath.lineTo(i,2160);
        }
        for (int i = 1080; i > 0; i--) {
            path.lineTo(i, (float) (vy - (50 * Math.sin(i * 2 * Math.PI / 1080 + vx))));
            //  mpath.lineTo(i, (float) (vy-(50*Math.sin(i*2*Math.PI/1080+Math.PI))));
        }
    }




    public void reset() {
        fragment2.mp.stop(); // to stop the pouring sound after animation gets over
       //Intent intent = new Intent(mcontext, next.class);
        //mcontext.startActivity(intent);




        FragmentTransaction ft=MainActivity.fm.beginTransaction();

        ft.add(R.id.mainactivity,fragmen);
        ft.setCustomAnimations(R.anim.leftin,R.anim.rightout,R.anim.rightin,R.anim.leftout);
        ft.hide(MainActivity.frag);
        ft.commit();


        vy = height;
        vx = 0;
    }


    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(1000 / 60);  //16 frames per seconds ...
            } catch (InterruptedException e) {
                break;
            }
            ((Activity) mcontext).runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    invalidate(); 


                }
            });
        }

    }
}
