package com.globant.corzo.creationals.singleton;

import java.io.IOException;

class Singleton
{

    public static void main(String args[])throws IOException
    {

        Sun a = Sun.getInstance();
        Sun b = Sun.getInstance();

        System.out.println("Sun a");
        a.shine();
        System.out.println("Sun b");
        b.shine();
    }
}
