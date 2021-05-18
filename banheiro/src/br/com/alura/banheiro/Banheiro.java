package br.com.alura.banheiro;

import java.util.concurrent.locks.ReentrantLock;

public class Banheiro {

    private final ReentrantLock lock = new ReentrantLock();

    private boolean ehSujo = true;

    public void fazNumero1() {
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

//        lock.lock();
        synchronized(this) {
            System.out.println(nome + " entrando no banheiro");

            while (ehSujo) {
                esperarLaFora(nome);
            }

            System.out.println(nome + " fazendo coisa rápida");

            dormirUmPouco(5_000);

            this.ehSujo = true;

            System.out.println(nome + " dando descarga");
            System.out.println(nome + " lavando mao");
            System.out.println(nome + " saindo do banheiro");
        }
//        lock.unlock();
    }

    public void fazNumero2() {
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        synchronized(this) {
            System.out.println(nome + " entrando no banheiro");

            while (ehSujo) {
                esperarLaFora(nome);
            }

            System.out.println(nome + " fazendo coisa demorada");

            dormirUmPouco(10_000);

            this.ehSujo = true;

            System.out.println(nome + " dando descarga");
            System.out.println(nome + " lavando mao");
            System.out.println(nome + " saindo do banheiro");
        }
    }

    public void limpar() {
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        synchronized(this) {
            System.out.println(nome + " entrando no banheiro");

            if (!ehSujo) {
                System.out.println(nome + ", não está sujo, vou sair");
                return;
            }

            System.out.println(nome + " limpando banheiro");
            this.ehSujo = false;

            dormirUmPouco(13_000);

            this.notifyAll();

            System.out.println(nome + " saindo do banheiro");
        }
    }

    private void esperarLaFora(String nome) {
        System.out.println(nome + ", eca, banheiro está sujo");
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void dormirUmPouco(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
