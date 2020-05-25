/*
https://www.urionlinejudge.com.br/judge/pt/problems/view/1288
BIANCA LIMA SANTOS 
GABRIEL ESTAVARINGO FERREIRA 
MARIANA SILVA SANTANA
*/

import java.util.*;

public class Main {

    public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
    
        int operacoes = sc.nextInt();
        
        for (int k = 0; k < operacoes; k++) {

            int projeteis = sc.nextInt();
        
            
            int[] poder = new int[projeteis+1];
            int[] peso = new int[projeteis+1];
        
            for (int j = 1; j <= projeteis; j++) {
                poder[j] = sc.nextInt();
                peso[j] = sc.nextInt();
            }
            
            int pesoMaximo = sc.nextInt();
            int poderNecessario = sc.nextInt();
        
            int[][] somas = new int[projeteis+1][pesoMaximo+1];
            
    		for(int i=0; i<=projeteis; i++){
			    for(int j=0; j<=pesoMaximo; j++){
    				if(i == 0 || j == 0){
    					somas[i][j] = 0;
    				}else{
    					if(peso[i] > j){
    						somas[i][j] = somas[i-1][j];
    					}
    					else{
    						somas[i][j] = Math.max(somas[i-1][j - peso[i]] + poder[i], somas[i-1][j]);
    					}
    				}
			    }
    		}

            if(somas[projeteis][pesoMaximo] >= poderNecessario){
                System.out.println("Missao completada com sucesso");
            }else{
                System.out.println("Falha na missao");
            }
            
        }
        sc.close();
    }
}
