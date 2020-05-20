/*
https://www.urionlinejudge.com.br/judge/pt/problems/view/1365
BIANCA LIMA SANTOS 
GABRIEL ESTAVARINGO FERREIRA 
MARIANA SILVA SANTANA
*/

import java.util.*;

public class Main {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        int K = sc.nextInt();

        while(R > 0){

            int[][] assentos = new int[R][C];

            for(int i = 0; i < R; i++){

                String linha = sc.next();

                for(int j = 0; j < C; j++){
                    assentos[i][j] = linha.charAt(j) == '.' ? 1 : 0; 
                }
            }

            int area = Integer.MAX_VALUE;

            for(int linhaReferencia = 0; linhaReferencia < R; linhaReferencia++){

                int[] assentosLivres = new int[C];

                for(int linhaAtual = linhaReferencia; linhaAtual < R; linhaAtual++){

                    for(int l = 0; l < C; l++) {
                        assentosLivres[l] += assentos[linhaAtual][l];
                    }

                    int reservados = 0;
                    int colunaReferencia = 0;

                    for (int colunaAtual = 0; colunaAtual < C; colunaAtual++ ) {
                        
                        reservados += assentosLivres[colunaAtual];

                        while((colunaReferencia < colunaAtual) && (reservados >=  K + assentosLivres[colunaReferencia])){
                            reservados -= assentosLivres[colunaReferencia];
                            colunaReferencia++;
                        }
                        
                        if(reservados >= K){
                            area = Math.min(area, calculaArea(linhaReferencia,linhaAtual,colunaReferencia,colunaAtual));
                        }
                    }
                }
            }

            System.out.println(area);

            R = sc.nextInt();
            C = sc.nextInt();
            K = sc.nextInt();
        }
    }
    
    public static int calculaArea(int linhaReferencia, int linhaAtual, int colunaReferencia, int colunaAtual){
        
        int linhas = linhaAtual - linhaReferencia + 1;
        int colunas = colunaAtual - colunaReferencia +1;
        
        return linhas * colunas;
        
    }
}
