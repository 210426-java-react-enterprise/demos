package com.revature.intro.class_loading;

public class Hawk extends Raptor {

    public static void main(String[] args) {
        System.out.println("init");
        new Hawk();
        System.out.println("hawk");
    }

}
