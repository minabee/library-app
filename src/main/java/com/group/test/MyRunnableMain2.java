package com.group.test;

public class MyRunnableMain2 {
    public static void main(String[] args) {

//        RunnableExecute runnableExecute = new RunnableExecute();
//        System.out.println("------------");
//        runnableExecute.execute(new MyRunnable() {
//            @Override
//            public void run() {
//                System.out.println("HELLO");
//            }
//        });
//        System.out.println("------------");

        RunnableExecute runnableExecute = new RunnableExecute();
        System.out.println("------------");
        runnableExecute.execute(() -> {
                    System.out.println("HELLO");
                }
        );
        System.out.println("------------");
    }



}
