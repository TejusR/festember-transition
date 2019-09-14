package com.example.featembertransition;

import java.util.ArrayList;
import java.util.List;

public   class utils {

    public static List<Bubble> bbl=new ArrayList<>();
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


}
