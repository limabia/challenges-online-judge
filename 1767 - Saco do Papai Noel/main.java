/*
https://www.urionlinejudge.com.br/judge/pt/problems/view/1767
BIANCA LIMA SANTOS 
GABRIEL ESTAVARINGO FERREIRA 
MARIANA SILVA SANTANA

Referência:
https://pt.wikipedia.org/wiki/Problema_da_mochila#Limitado_0/1
https://www.ime.usp.br/~cris/aulas/08_1_338/slides/aula17.pdf
*/

import java.util.*;

public class Main {

    static int[] brinquedos;
    static int[] peso;
    static int somaBrinquedos;
    static int somaPeso;
    static int pesoMaximo = 50;

    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
    
        int operacoes = sc.nextInt();
        
        for (int k = 0; k < operacoes; k++) {

            int pacotes = sc.nextInt();
            
            somaBrinquedos = 0;
            somaPeso = 0;
            
            brinquedos = new int[pacotes+1];
            peso = new int[pacotes+1];
        
            for (int j = 1; j <= pacotes; j++) {
                brinquedos[j] = sc.nextInt();
                peso[j] = sc.nextInt();
            }
        
            int[][] somas = new int[pacotes+1][pesoMaximo+1];
            
    		for(int i=0; i<=pacotes; i++){
			    for(int j=0; j<=pesoMaximo; j++){
    				if(i == 0 || j == 0){
    					somas[i][j] = 0;
    				}else{
    					if(peso[i] > j){
    						somas[i][j] = somas[i-1][j];
    					}
    					else{
    						somas[i][j] = Math.max(somas[i-1][j - peso[i]] + brinquedos[i], somas[i-1][j]);
    					}
    				}
			    }
    		}
    		
    		int pacotesTotais = 0;
    		int pesoTotal = 0;
    		int j = pesoMaximo;
    		
    		for(int i = pacotes; i > 0; i--){
    		    if(somas[i][j] != somas[i-1][j]){
    		        pacotesTotais++;
    		        pesoTotal += peso[i];
				    if(j - peso[i] >= 0){
					    j -= peso[i];
				    }
    		    }
    		}
        
            System.out.println(somas[pacotes][pesoMaximo] + " brinquedos");
            System.out.println("Peso: " + pesoTotal + " kg");
            System.out.println("sobra(m) " + (pacotes - pacotesTotais) +" pacote(s)");
            System.out.println("");
    
        }
        sc.close();
    }
}
