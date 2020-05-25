/*
https://www.urionlinejudge.com.br/judge/pt/problems/view/2446
BIANCA LIMA SANTOS 
GABRIEL ESTAVARINGO FERREIRA 
MARIANA SILVA SANTANA
Referência:
https://pt.wikipedia.org/wiki/Problema_da_mochila#Limitado_0/1
https://www.ime.usp.br/~cris/aulas/08_1_338/slides/aula17.pdf
*/

import java.util.*;

public class Main {


    public static void main(String args[]) {
        // Le a entrada
        Scanner sc = new Scanner(System.in);
    
        int valor = sc.nextInt();
        int n_moedas = sc.nextInt();

        int[] moedas = new int[n_moedas];
        for (int i=0; i<n_moedas; i++) {
            moedas[i] = sc.nextInt();
        }
        sc.close();
        
        // Resolve o problema
        boolean t[][] = new boolean[n_moedas+1][valor+1];
        for (int y=0; y<=valor; y++) {
            if (y == 0) t[0][y] = true;  // o problema de valor 0 é resolvido com 0 moedas
            else t[0][y] = false;  // o problema de valor > 0 não pode ser resolvido
            
            for (int i=1; i<=n_moedas; i++) {
                // reduz o problema retirando uma moeda
                boolean a = t[i-1][y];  // solução sem usar a moeda i
                boolean b = false;
                if (moedas[i-1] <= y) {
                    b = t[i-1][y-moedas[i-1]]; // solução usando a moeda i
                }
                t[i][y] = a || b; // problema menor pode ser resolvido com ou sem a moeda i
            }
        }
    
        // Imprime a saída
        System.out.println(t[n_moedas][valor] ? "S" : "N");
    }
}
