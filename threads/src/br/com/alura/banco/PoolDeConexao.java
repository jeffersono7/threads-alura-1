package br.com.alura.banco;

public class PoolDeConexao {

    public String getConnection() {

        System.out.println("Emprestando conexão");

        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "connection";
    }
}
