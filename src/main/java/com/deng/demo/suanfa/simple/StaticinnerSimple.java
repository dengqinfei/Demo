package com.deng.demo.suanfa.simple;

public class StaticinnerSimple {

    private StaticinnerSimple(){

    }

    private static class Inner{

        private static final StaticinnerSimple staticinnerSimple = new StaticinnerSimple();
    }

    public StaticinnerSimple getInstance(){

        return  Inner.staticinnerSimple;
    }
}
