package com.library.system.instrument;

public class TestApplication {

    public static void main(String[] args) {

        try {
            TestApplication.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void run() throws Exception {
        System.out.println("--- start ---");

        while (true) {
            test();
            Thread.sleep(4_000);
        }


    }


    static int count = 0;

    public static void test() {
        System.out.println(count++);
    }

}