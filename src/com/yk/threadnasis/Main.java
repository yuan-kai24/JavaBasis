package com.yk.threadnasis;

public class Main {
    public static void main(String[] args) {
        Thread actor = new Actor();
        Thread actress = new Thread(new Actress(), "123");
        actor.setName("YK");
        actress.start();
        actor.start();
    }
}
