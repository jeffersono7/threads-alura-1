package br.com.alura.threads.exercicios;

public class ImprimeString implements Runnable {

    @Override
    public void run() {
        System.out.println("My name is Jefferson, i'm inside other thread: " + Thread.currentThread().getName());
    }
}
