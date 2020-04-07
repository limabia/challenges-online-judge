/*
Grid de largada
https://www.urionlinejudge.com.br/judge/pt/problems/view/1228
BIANCA LIMA SANTOS 
GABRIEL ESTAVARINGO FERREIRA 
MARIANA SILVA SANTANA
*/

import java.util.*;

public class Main { 
   
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    while(sc.hasNextInt()) {
      int qtdCompetidores = sc.nextInt();             
      int[] largada = new int[qtdCompetidores];
      int[] chegada = new int[qtdCompetidores];
      
      for(int i = 0; i < qtdCompetidores; i++){
        largada[i] = sc.nextInt();                  
      }
      
      for(int i = 0; i < qtdCompetidores; i++){
        chegada[i] = sc.nextInt();                
      }
            
      int qtdOperacoes = 0;
      
      for(int i = 0; i < chegada.length; i++){
        int elemento = chegada[i];                
        int posFinal = i;                         
        int posAtual = 0;                       
        
        for(int j = 0; j<largada.length; j++){
          if(elemento == largada[j]){
            posAtual = j;                     
            break;
          }
        }
        
        int diferenca = posAtual - posFinal;
        
        qtdOperacoes += diferenca;            
        
        if(diferenca == 0) continue;
    
                                                        
        while(posAtual > posFinal){                     
          int temp = largada[posAtual-1];               
          largada[posAtual-1] = largada[posAtual];      
          largada[posAtual] = temp;                     
          posAtual--;   
        }
        
      }
      System.out.println(qtdOperacoes); 
    }
    sc.close();
  }
}

     