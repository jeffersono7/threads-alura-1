package br.com.alura.threads.exercises;

public class ImpressaoNumeros implements Runnable {

    public static void main(String... args) {

        Thread thread1 = new Thread(new ImpressaoNumeros());
        Thread thread2 = new Thread(new ImpressaoNumeros());

        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        for(int i = 1; i <= 1000; i++) {
            System.out.println("ID Thread: " + Thread.currentThread().getId() + " -> " + i);
        }
    }
}
