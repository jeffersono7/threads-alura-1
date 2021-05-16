package br.com.alura.threads.exercicios;

public class Principal {

    public static void main(String... args) {

        Runnable tarefaImprime1 = new ImprimeString();
        Runnable tarefaImprime2 = new ImprimeString();
        Runnable tarefaImprime3 = new ImprimeString();

        Thread thread1 = new Thread(tarefaImprime1);
        Thread thread2 = new Thread(tarefaImprime2);
        Thread thread3 = new Thread(tarefaImprime3);

        thread1.start();
        thread2.start();
        thread3.start();

        // usando classe anônima
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("imprimindo...");
            }
        }).start();

        // usando lambda
        new Thread(() -> System.out.println("lambda...")).start();
    }
}
