package com.deng.demo.suanfa.simple;

public class LanhanSimple {

    private static volatile LanhanSimple simple = null;

    private LanhanSimple(){}

    public static LanhanSimple getInstance() {
        if (simple == null) {

            synchronized (LanhanSimple.class) {
                if (simple == null) {
                    return new LanhanSimple();
                }
            }
        }
        return null;

    }
}
