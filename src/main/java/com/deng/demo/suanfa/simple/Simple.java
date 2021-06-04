package com.deng.demo.suanfa.simple;

public class Simple {

    private static Simple simple = new Simple();
    private Simple(){

    }
    public static Simple getSimple(){
        return simple;
    }

}
