package com.example.featembertransition;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class down {
    Context context;


 public Bitmap bitmap;
int screenheight= Resources.getSystem().getDisplayMetrics().heightPixels;
int screenwidth=Resources.getSystem().getDisplayMetrics().widthPixels;

int x=screenwidth;
int y=screenheight;
long mstarttime;
float yVelocity;
Paint paint;





    public down(Context context) {
        this.context = context;
        initialize();

    }
    public void draw(Canvas canvas){
        update();

        canvas.drawBitmap(bitmap,x,y,paint);


    }
    public void update(){
        long realTimeMillisecond=System.currentTimeMillis()-mstarttime;

        bitmap=Bitmap.createBitmap(bitmap,0,0,screenwidth,(int)y);
        y+=yVelocity*realTimeMillisecond;

    }

    public void initialize(){


        paint=new Paint();
        paint.setColor(Integer.parseInt("#652121"));

        mstarttime=System.currentTimeMillis();
        yVelocity=0.05f;
      x=0;
        y=0;


    }
}
