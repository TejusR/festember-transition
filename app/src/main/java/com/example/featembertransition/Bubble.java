package com.example.featembertransition;

public class Bubble {
    float x,y,size;

    public Bubble(float x, float y,float size) {
        this.x = x;
        this.y = y;
        this.size=size;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    public float getSize()
    {
        return size;
    }
    public void positionUpdate()
    {
        y-=50;
    }
}