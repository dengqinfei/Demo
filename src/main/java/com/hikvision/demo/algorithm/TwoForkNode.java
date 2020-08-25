package com.hikvision.demo.algorithm;

public class TwoForkNode {
    private int data;
    private TwoForkNode left;
    private TwoForkNode right;

    public TwoForkNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TwoForkNode getLeft() {
        return left;
    }

    public void setLeft(TwoForkNode left) {
        this.left = left;
    }

    public TwoForkNode getRight() {
        return right;
    }

    public void setRight(TwoForkNode right) {
        this.right = right;
    }
}
