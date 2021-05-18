package br.com.alura.banco;

public class PrincipalBanco {

    public static void main(String ...args) throws InterruptedException {

        GerenciadorDeTransacao tx = new GerenciadorDeTransacao();
        PoolDeConexao pool = new PoolDeConexao();

        new Thread(new TarefaAcessaBanco(pool, tx)).start();
        new Thread(new TarefaAcessaProcedimento(pool, tx)).start();
    }
}
