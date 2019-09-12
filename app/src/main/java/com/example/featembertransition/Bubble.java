package com.example.featembertransition;

public class Bubble {
    float x, y, size, acc, speed, sizeRate;

    public Bubble(float x, float y, float size, float speed, float acc, float sizeRate) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.speed = speed;
        this.acc = acc;
        this.sizeRate = sizeRate;

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getSize() {
        return size;
    }

    public float getAcc() {
        return acc;
    }

    public float getSpeed() {
        return speed;
    }

    public void positionUpdate() {
        speed += acc;
        y -= speed;
        size += sizeRate;
    }
}