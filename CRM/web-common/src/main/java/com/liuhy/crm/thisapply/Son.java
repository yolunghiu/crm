package com.liuhy.crm.thisapply;

public class Son extends Parent {
    public void init() {
        super.init();
        System.out.println("3 in son");
        this.demo();
    }

    public void demo() {
        System.out.println("4 in son");
    }

    public static void main(String[] args) {
        Son son = new Son();

        /*
        * 执行结果是1 4 3 4
        * 说明this指向的是正在运行的对象
        * */
        son.init();
    }
}
