/*
Diga me a frequência 
https://www.urionlinejudge.com.br/judge/pt/disciplines/view/6028
BIANCA LIMA SANTOS 
GABRIEL ESTAVARINGO FERREIRA 
MARIANA SILVA SANTANA 
*/

import java.util.*;

public class Main { 
   
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    while(sc.hasNextLine()) {
    HashMap<Character, Integer> hashMap = new HashMap<>();    
      int freq = 0;
      String input = sc.nextLine();
      
      for (char c : input.toCharArray()) {
        if (hashMap.containsKey(c)) {
          freq = hashMap.get(c);
          freq++;
          hashMap.replace(c, freq);
        } else {
          hashMap.put(c, 1);
        }
      }
      
      PriorityQueue<Caractere> pq = new PriorityQueue(1000, new SortByValue());
          
      for (Map.Entry<Character, Integer> pair : hashMap.entrySet()) {
        Caractere obj = new Caractere();
        obj.setCaractere(pair.getKey());
        obj.setFreq(pair.getValue());
        pq.add(obj);
      }
      
      while(pq.size() > 0) {
        Caractere obj = pq.poll();
        System.out.println((int) obj.getCaractere() + " " + obj.getFreq());
      }
      if(sc.hasNextLine()) {
        System.out.println();
      }
    }
    sc.close();
  }
  
   public static class Caractere {

        private char caractere;
        private int freq;

        public char getCaractere() {
            return caractere;
        }

        public void setCaractere(char caractere) {
            this.caractere = caractere;
        }

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }
    }

  public static class SortByValue implements Comparator<Caractere> { 
    
    public int compare(Caractere a, Caractere b) { 
      if(a.freq == b.freq) {
        return (int) b.caractere - (int) a.caractere; 
      }
      return a.freq - b.freq;
    }
  } 
} 