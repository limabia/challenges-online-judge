/*
https://www.urionlinejudge.com.br/judge/pt/problems/view/1259
BIANCA LIMA SANTOS 
GABRIEL ESTAVARINGO FERREIRA 
MARIANA SILVA SANTANA
*/

import java.util.*;

public class Main {


    public static void main(String args[]) {
        // Le a entrada
        Scanner sc = new Scanner(System.in);
    
        int qtdNumeros = sc.nextInt();

        ArrayList<Integer> pares = new  ArrayList<>();
        ArrayList<Integer> impares = new  ArrayList<>();

        for (int i=0; i<qtdNumeros; i++) {
            int numero = sc.nextInt();
            
            if(numero % 2 == 0){
                pares.add(numero);
            }else{
                impares.add(numero);
            }
            
        }
        
        Collections.sort(pares);         
  
        Collections.sort(impares, Collections.reverseOrder());   
        
        for(int numero : pares){
            System.out.println(numero);
        }
        for(int numero : impares){
            System.out.println(numero);
        }
    }
}
