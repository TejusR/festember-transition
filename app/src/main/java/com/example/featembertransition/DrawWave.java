package com.example.featembertransition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.List;

public class DrawWave extends View {
    Paint p,p1;
    Path path,mpath;
    float vx=0;
    float vy=2160;
    int count=0;
    public DrawWave(Context context)
    {
        super(context);
    }

    public DrawWave(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawWave(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DrawWave(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        Log.d("!!!!!!!!!!!", String.valueOf(Thread.currentThread()));
        p=new Paint();
        p1=new Paint();
        p.setColor(Color.parseColor("#652121"));
        p1.setColor(Color.parseColor("#412E15"));

        p.setStyle(Paint.Style.FILL_AND_STROKE);
        p1.setStyle(Paint.Style.FILL_AND_STROKE);
        if(vy<-200)
        {
            reset();
        }
        createPath();
        if(count%2==0)
        {
            MainActivity.generateBubble();
        }
        count++;
       // canvas.drawPath(mpath,p1);
        canvas.drawPath(path,p);
        vx+=0.2;
        vy-=10;
        for(int i=0;i<MainActivity.bbl.size();i++)
        {
            MainActivity.bbl.get(i).positionUpdate();
            if(MainActivity.bbl.get(i).getY()>vy-(50*Math.sin(MainActivity.bbl.get(i).getX()*2*Math.PI/1080+Math.PI)))
            {
                Drawable d=getResources().getDrawable(R.drawable.bubble_filter);
                d.setBounds((int)MainActivity.bbl.get(i).getX(),(int)MainActivity.bbl.get(i).getY(),(int)MainActivity.bbl.get(i).getX()+(int) MainActivity.bbl.get(i).size,(int)MainActivity.bbl.get(i).getY()+(int) MainActivity.bbl.get(i).size);
                d.draw(canvas);
            }
    /*        else
            {
                MainActivity.bbl[i]=new Bubble(
                        MainActivity.generateRandom(0, 1080),
                        2160,
                        MainActivity.generateRandom(4, 5),
                        MainActivity.generateRandom(0.01f, 1f),
                        MainActivity.generateRandom(0.1f, 0.3f),
                        0.5f
                );
            }*/
        }
        invalidate();
    }
    public void createPath(){
        path=new Path();
        mpath=new Path();
        path.reset();
        mpath.reset();
        path.moveTo(0,2160);
        for(int i=0;i<1080;i++)
        {
            path.lineTo(i,2160);
            mpath.lineTo(i,2160);
        }
        for(int i=1080;i>0;i--)
        {
            path.lineTo(i, (float) (vy-(50*Math.sin(i*2*Math.PI/1080+vx))));
            mpath.lineTo(i, (float) (vy-(50*Math.sin(i*2*Math.PI/1080+Math.PI))));
        }
    }
    public void reset()
    {
        vy=2160;
        vx=0;
    }
}
