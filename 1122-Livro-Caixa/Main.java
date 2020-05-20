/*
Livro Caixa
https://www.urionlinejudge.com.br/judge/pt/problems/view/1122
BIANCA LIMA SANTOS 
GABRIEL ESTAVARINGO FERREIRA 
MARIANA SILVA SANTANA
*/

import java.util.*;

public class Main {

 static int[] operations;
 static int[] positive;
 static int[] negative;
 static int sum;
 static Map < Pair, Boolean > done = new HashMap < Pair, Boolean > ();

 public static void main(String args[]) {
  Scanner sc = new Scanner(System.in);

  while (sc.hasNextInt()) {
   int nOperations = sc.nextInt();
   sum = sc.nextInt();

   if (nOperations == 0) {
    return;
   }

   operations = new int[nOperations];
   positive = new int[nOperations];
   negative = new int[nOperations];

   for (int i = 0; i < operations.length; i++) {
    operations[i] = sc.nextInt();
    positive[i] = -1;
    negative[i] = -1;
   }


   done.clear();

   boolean valid = checkSum(0, 0);

   StringBuilder sb = new StringBuilder();



   if (valid) {
    for (int i = 0; i < nOperations; i++) {
     if (positive[i] == 0 && negative[i] == 0) {
      sb.append("?");
     } else if (positive[i] == 0 && negative[i] == -1) {
      sb.append("+");
     } else if (positive[i] == -1 && negative[i] == 0) {
      sb.append("-");
     }
    }
   } else {
    sb.append("*");
   }

   System.out.println(sb);

  }
  sc.close();
 }

 public static boolean checkSum(int number, int indexNextOperation) {

  if (indexNextOperation >= operations.length) {
   if (number == sum) {
    return true;
   }
   return false;
  }

  Pair p = new Pair(indexNextOperation, number);

  if (done.containsKey(p)) {
   return done.get(p);
  }


  boolean saida = checkSum(number - operations[indexNextOperation], indexNextOperation + 1);
  boolean entrada = checkSum(number + operations[indexNextOperation], indexNextOperation + 1);



  if (saida && entrada) {
   positive[indexNextOperation] = 0;
   negative[indexNextOperation] = 0;
  } else if (saida && !entrada) {
   negative[indexNextOperation] = 0;
  } else if (!saida && entrada) {
   positive[indexNextOperation] = 0;
  }

  done.put(p, saida || entrada);

  return (saida || entrada);

 }


 public static class Pair {

  public Integer id;
  public Integer number;

  public Pair(int id, int number) {
   this.id = id;
   this.number = number;
  }

  @Override
  public int hashCode() {
   return id.hashCode() ^ number.hashCode();
  }

  @Override
  public boolean equals(Object o) {
   if (!(o instanceof Pair)) return false;
   Pair pairo = (Pair) o;
   return this.id.equals(pairo.id) &&
    this.number.equals(pairo.number);
  }

 }

}
