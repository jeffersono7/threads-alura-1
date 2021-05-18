package br.com.alura.lista;

public class TarefaImprimir implements Runnable {

    private final Lista lista;

    public TarefaImprimir(Lista lista) {
        this.lista = lista;
    }

    @Override
    public void run() {

//        try {
//            Thread.sleep(1_000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        synchronized (lista) {
            if (!lista.estaCheia()) {
                try {
                    System.out.println("indo esperar, aguardando notificação");
                    lista.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < lista.tamanho(); i++) {
                System.out.println(i + " - " + lista.pegaElemento(i));
            }
        }
    }
}
