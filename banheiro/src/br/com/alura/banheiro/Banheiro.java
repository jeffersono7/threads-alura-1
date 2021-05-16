package br.com.alura.banheiro;

import java.util.concurrent.locks.ReentrantLock;

public class Banheiro {

    private final ReentrantLock lock = new ReentrantLock();

    public void fazNumero1() {
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        lock.lock();

        System.out.println(nome + " entrando no banheiro");
        System.out.println(nome + " fazendo coisa rápida");

        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(nome + " dando descarga");
        System.out.println(nome + " lavando mao");
        System.out.println(nome + " saindo do banheiro");

        lock.unlock();
    }

    public void fazNumero2() {
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        synchronized(this) {
            System.out.println(nome + " entrando no banheiro");
            System.out.println(nome + " fazendo coisa demorada");

            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(nome + " dando descarga");
            System.out.println(nome + " lavando mao");
            System.out.println(nome + " saindo do banheiro");
        }
    }
}
