/*
https://www.urionlinejudge.com.br/judge/pt/problems/view/1523
BIANCA LIMA SANTOS 
GABRIEL ESTAVARINGO FERREIRA 
MARIANA SILVA SANTANA
*/

import java.util.*;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        
        while (N > 0 && K >0) {

            PriorityQueue <Estacionamento> pq = new PriorityQueue(N*2, new SortByValue());
            
            Stack<Estacionamento> pilha = new Stack<Estacionamento>();
            
            for(int i = 1; i <= N; i++){
                int ordem = sc.nextInt();
                Estacionamento est1 = new Estacionamento(i, ordem, 'e');
                ordem = sc.nextInt();
                Estacionamento est2 = new Estacionamento(i, ordem, 's');
                pq.add(est1);
                pq.add(est2);
            }
            
            
            
            while (pq.size() > 0) {
                Estacionamento est = pq.poll();
                
                if(est.op == 'e'){
                    pilha.push(est);
                    if(pilha.size() > K){
                        System.out.println("Nao");
                        break;
                    }
                }else{
                    Estacionamento est2 = pilha.pop();
                    if(!est.equals(est2)){
                        System.out.println("Nao");
                        break;
                    }
                }
            }
            
            if(pq.size() == 0){
                System.out.println("Sim");
            }
            
            
            N = sc.nextInt();
            K = sc.nextInt();
        
        }
        sc.close();
    }



    public static class Estacionamento {
        public int motorista;
        public int ordem;
        public char op;

        public Estacionamento(int motorista, int ordem, char op) {
            this.motorista = motorista;
            this.ordem = ordem;
            this.op = op;
        }

        @Override
        public boolean equals(Object o) {
            Estacionamento est = (Estacionamento) o;
            return (this.motorista == est.motorista);
        }
    }


    public static class SortByValue implements Comparator < Estacionamento > {
        public int compare(Estacionamento a, Estacionamento b) {
            if(a.ordem == b.ordem){
                if(a.op == 's'){
                    if(a.motorista == b.motorista){
                        return 1;
                    }else{
                        return -1;
                    }
                }else{
                    if(a.motorista == b.motorista){
                        return -1;
                    }else{
                        return 1;
                    }
                }
            }
            return a.ordem - b.ordem;
        }
    }
}
