/*
https://www.urionlinejudge.com.br/judge/pt/problems/view/1519
BIANCA LIMA SANTOS 
GABRIEL ESTAVARINGO FERREIRA 
MARIANA SILVA SANTANA
*/

import java.util.*;


public class Main {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);

        String frase = sc.nextLine();
        
        while(!frase.equals(".")){
            
            String[] palavras = frase.split(" ");
            
            PriorityQueue<Pair> pq = new PriorityQueue(palavras.length, new SortByTamanho());
            
            HashMap<String, Integer> palavrasTamanho = new HashMap<>();
            
            for(String palavra : palavras){
                if(palavrasTamanho.containsKey(palavra)){
                    int tamanho = palavrasTamanho.get(palavra);
                    palavrasTamanho.put(palavra, tamanho+ (palavra.length() - 2));
                }else{
                    palavrasTamanho.put(palavra, palavra.length() - 2);
                }
            }
            
            for(Map.Entry<String, Integer> entry : palavrasTamanho.entrySet()){
                Pair par = new Pair(entry.getKey(), entry.getValue());
                pq.add(par);
            }
            
            
            HashSet<String> palavraAbreviada = new HashSet<>();
            HashSet<Character> abreviacao = new HashSet<>();
            
            
            while(pq.size() > 0){
                Pair par = pq.poll();
                if(par.tamanho > 0){
                    char primeiraLetra = par.palavra.charAt(0);
                    if(abreviacao.add(primeiraLetra)){
                        palavraAbreviada.add(par.palavra);
                    }
                }
            }
            
            
            for(int i = 0; i < palavras.length; i++){
                String palavra = palavras[i];
                if(i == 0){
                    if(palavraAbreviada.contains(palavra)){
                        System.out.print(palavra.charAt(0) + ".");
                    }else{
                        System.out.print(palavra);
                    }
                }else{
                    if(palavraAbreviada.contains(palavra)){
                        System.out.print(" " + palavra.charAt(0) + ".");
                    }else{
                        System.out.print(" " + palavra);
                    }
                }
            }
            
            
            System.out.println();
            System.out.println(palavraAbreviada.size());
            
            
            Arrays.sort(palavras);
            
            for(String palavra : palavras){
                if(palavraAbreviada.contains(palavra)){
                    System.out.println(palavra.charAt(0) + "." + " = " + palavra);
                    palavraAbreviada.remove(palavra);
                }
            }
            
            frase = sc.nextLine();
            
        }
        
    }
    
    public static class Pair {

        public String palavra;
        public Integer tamanho;
        
        public Pair(String palavra, int tamanho) {
            this.palavra = palavra;
            this.tamanho = tamanho;
        }
        
        @Override
        public int hashCode() {
            return palavra.hashCode();
        }
        
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) return false;
            Pair pairo = (Pair) o;
            return this.palavra.equals(pairo.palavra);
        }
    }
    
    public static class SortByTamanho implements Comparator < Pair > {
        public int compare(Pair a, Pair b) {
            return b.tamanho - a.tamanho;
        }
    }
    
}