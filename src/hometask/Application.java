package hometask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        //thread.run();
        RunnableThread runnableThread = new RunnableThread();
    }
}

class MyThread extends Thread {
    Scanner scn = new Scanner(System.in);
    int size, newNumber = 0, Number = 1, prevNumber = 0;

    @Override
    public void run() {
        System.out.print("Enter count of Fibonachi: ");
        size = scn.nextInt();

        for (int i = 0; i <= size; i++) {
            if (i <= 1) System.out.println(i + ") " + i);
            else {
                newNumber = Number + prevNumber;
                prevNumber = Number;
                Number = newNumber;
                System.out.println(i + ") " + newNumber);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class RunnableThread implements Runnable {
    Scanner scn = new Scanner(System.in);
    List<Integer> list = new ArrayList<>();
    Thread thread;
    int size, newNumber = 0, Number = 1, prevNumber = 0;

    RunnableThread () {
        thread = new Thread(this);
        thread.run();
    }

    @Override
    public void run() {
        System.out.print("Enter count of Fibonachi: ");
        size = scn.nextInt();

        for (int i = 0; i <= size; i++) {
            if (i <= 1) list.add(i);
            else {
                newNumber = Number + prevNumber;
                prevNumber = Number;
                Number = newNumber;
                list.add(newNumber);
            }
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(i + ") " + list.get(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
