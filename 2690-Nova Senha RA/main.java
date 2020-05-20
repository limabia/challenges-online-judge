/*
https://www.urionlinejudge.com.br/judge/pt/problems/view/2690
BIANCA LIMA SANTOS 
GABRIEL ESTAVARINGO FERREIRA 
MARIANA SILVA SANTANA
*/

import java.util.*;


public class Main {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        
        HashMap<Character, Integer> letras = new HashMap<>();

        letras.put('G',0);
        letras.put('Q',0);
        letras.put('a',0);
        letras.put('k',0);
        letras.put('u',0);
        letras.put('I',1);
        letras.put('S',1);
        letras.put('b',1);
        letras.put('l',1);
        letras.put('v',1);
        letras.put('E',2);
        letras.put('O',2);
        letras.put('Y',2);
        letras.put('c',2);
        letras.put('m',2);
        letras.put('w',2);
        letras.put('F',3);
        letras.put('P',3);
        letras.put('Z',3);
        letras.put('d',3);
        letras.put('n',3);
        letras.put('x',3);
        letras.put('J',4);
        letras.put('T',4);
        letras.put('e',4);
        letras.put('o',4);
        letras.put('y',4);
        letras.put('D',5);
        letras.put('N',5);
        letras.put('X',5);
        letras.put('f',5);
        letras.put('p',5);
        letras.put('z',5);
        letras.put('A',6);
        letras.put('K',6);
        letras.put('U',6);
        letras.put('g',6);
        letras.put('q',6);
        letras.put('C',7);
        letras.put('M',7);
        letras.put('W',7);
        letras.put('h',7);
        letras.put('r',7);
        letras.put('B',8);
        letras.put('L',8);
        letras.put('V',8);
        letras.put('i',8);
        letras.put('s',8);
        letras.put('H',9);
        letras.put('R',9);
        letras.put('j',9);
        letras.put('t',9);
        
        
        int qtd = Integer.parseInt(sc.nextLine());
        
        for(int i = qtd; i > 0; i--){
            
            String frase = sc.nextLine();
            
            StringBuilder sb = new StringBuilder();
            
                    
            for(Character c : frase.toCharArray()){
                Integer numero = letras.get(c);
                if(numero != null){
                    sb.append(numero);
                    if(sb.length() == 12){
                        break;
                    }
                }
            }
            System.out.println(sb);
        }
        
    }
}
