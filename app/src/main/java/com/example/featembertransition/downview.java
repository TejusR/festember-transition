package com.example.featembertransition;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public class downview extends View implements Runnable {

    Context context;
down mdown;

    public downview(Context context, Context context1) {
        super(context);
        this.context = context1;
     initialize();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (canvas!=null){
            mdown.draw(canvas);
        }




        super.onDraw(canvas);
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                break;
            }
            ((Activity) context).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    invalidate();
                }
            });
        }

    }
  public void initialize(){
      mdown=new down(context);
        mdown.initialize();

  }
}
