package com.example.featembertransition;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
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
import androidx.fragment.app.FragmentTransaction;

public class cokedownview extends View implements Runnable {
    Paint p;
    Path path;
    float vx=0;
    float vy=0;
    int count=0;
    private Context mcontext;
    int height= Resources.getSystem().getDisplayMetrics().heightPixels;
    int width=Resources.getSystem().getDisplayMetrics().widthPixels;


    public cokedownview(Context context)
    {

        super(context);
        this.mcontext=context;

    }

    public cokedownview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mcontext=context;
    }

    public cokedownview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mcontext=context;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public cokedownview(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
Log.d("MMMMMMMMMM","done it ");

        p=new Paint();

        p.setColor(Color.parseColor("#652121"));



        p.setStyle(Paint.Style.FILL_AND_STROKE);




     /*   if(vy>height+25)
        {
            reset();


        }

      */



        createPath();


        if(count%2==0)
        {
            fragment3.generateBubble();
        }

        count++;

        canvas.drawPath(path,p);
        vx+=0.2;
        vy+=50;
        for(int i=0;i<fragment2.bbl.size();i++)
        {
            fragment2.bbl.get(i).positionUpdate();

            if(fragment2.bbl.get(i).getY()>vy-(50*Math.sin(fragment2.bbl.get(i).getX()*2*Math.PI/1080+Math.PI)))
            {
                Drawable d=getResources().getDrawable(R.drawable.bubble_filter);
                d.setBounds((int)fragment2.bbl.get(i).getX(),(int)fragment2.bbl.get(i).getY(),(int)fragment2.bbl.get(i).getX()+(int) fragment2.bbl.get(i).size,(int)fragment2.bbl.get(i).getY()+(int) fragment2.bbl.get(i).size);
                d.draw(canvas);
            }

        }
        invalidate();
    }
    public void createPath(){
        path=new Path();
        path.reset();
        path.moveTo(0,height);
        for(int i=0;i<1080;i++)
        {
            path.lineTo(i,2160);

        }
        for(int i=1080;i>0;i--)
        {
            path.lineTo(i, (float) (vy-(50*Math.sin(i*2*Math.PI/1080+vx))));

        }
    }



    public void reset()
    {

        vy=height+50;
        vx=width;
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

    public static float generateRandom(float x, float y) {
        return (float) Math.random() * (y - x) + x;
    }
    public  void  generateBubble()
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
}
