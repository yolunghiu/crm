package com.liuhy.crm.thisapply;

public class Parent {
    public void init() {
        System.out.println("1 in parent");
        this.demo();
    }

    public void demo() {
        System.out.println("2 in parent");
    }
}
