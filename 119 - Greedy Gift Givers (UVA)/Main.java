/*
Greedy Gift Givers
https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=55
BIANCA LIMA SANTOS 
GABRIEL ESTAVARINGO FERREIRA 
MARIANA SILVA SANTANA
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int iteracao = 1;
        while (s.hasNextInt()) {
            if (iteracao > 1) {
                System.out.println();
            }
            int qtdPessoas = s.nextInt();
            ArrayList<Pessoa> listaPessoas = new ArrayList<>();

            for (int j = 0; j < qtdPessoas; j++) {
                String nome = s.next();
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(nome);
                pessoa.setDinheiro(0);
                listaPessoas.add(pessoa);
            }

            for (int j = 0; j < qtdPessoas; j++) {

                String nomeDoador = s.next();
                Pessoa doador = new Pessoa();
                for (Pessoa pessoa : listaPessoas) {
                    if (pessoa.getNome().equals(nomeDoador)) {
                        doador = pessoa;
                        break;
                    }
                }

                int qtdDoacao = s.nextInt();
                int qtdGanhadores = s.nextInt();
                int valorParaCada = 0;
                if (qtdGanhadores != 0) {
                    valorParaCada = qtdDoacao / qtdGanhadores;
                }
                doador.setDinheiro(doador.getDinheiro() - valorParaCada * qtdGanhadores);
                for (int i = 0; i < qtdGanhadores; i++) {
                    String nomeRecebedor = s.next();
                    Pessoa recebedor = new Pessoa();
                    for (Pessoa pessoa : listaPessoas) {
                        if (pessoa.getNome().equals(nomeRecebedor)) {
                            recebedor = pessoa;
                            break;
                        }
                    }
                    recebedor.setDinheiro(recebedor.getDinheiro() + valorParaCada);
                }

            }
            listaPessoas.forEach((pessoa) -> {
                System.out.println(pessoa.getNome() + " " + pessoa.getDinheiro());
            });
            iteracao++;
        }
    }

    public static class Pessoa {

        private String nome;
        private int dinheiro;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getDinheiro() {
            return dinheiro;
        }

        public void setDinheiro(int dinheiro) {
            this.dinheiro = dinheiro;
        }
    }
}
