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
 static ArrayList < ArrayList < Character >> results = new ArrayList < > ();
 static int sum;

 public static void main(String args[]) {
  Scanner sc = new Scanner(System.in);

  while (sc.hasNextInt()) {
   int nOperations = sc.nextInt();
   sum = sc.nextInt();

   if (nOperations == 0) {
    return;
   }

   operations = new int[nOperations];

   for (int i = 0; i < operations.length; i++) {
    operations[i] = sc.nextInt();
   }

   results = new ArrayList < > ();

   ArrayList < Character > currSignals = new ArrayList < Character > ();

   checkSum(currSignals, 0, 0);

   StringBuilder sb = new StringBuilder();

   if (results.size() == 0) {
    sb.append("*");
   } else if (results.size() == 1) {
    ArrayList < Character > signals = results.get(0);
    for (int i = signals.size() - 1; i >= 0; i--) {
     sb.append(signals.get(i));
    }
   } else {
    ArrayList < Character > firstResult = results.get(0);
    for (int i = 0; i < operations.length; i++) {
     boolean equal = true;
     Character signal = firstResult.get(i);

     for (int j = 1; j < results.size(); j++) {
      if (signal != results.get(j).get(i)) {
       equal = false;
       break;
      }
     }

     if (equal) {
      sb.append(signal);
     } else {
      sb.append("?");
     }
    }
   }

   System.out.println(sb);

  }
  sc.close();
 }

 public static void checkSum(ArrayList < Character > currSignals, int number, int indexNextOperation) {

  if (indexNextOperation >= operations.length) {
   if (number == sum) {
    ArrayList < Character > foundSignals = (ArrayList < Character > ) currSignals.clone();
    results.add(foundSignals);
   } else if (number * -1 == sum) {
    ArrayList < Character > foundSignals = new ArrayList < Character > ();
    for (char c: currSignals) {
     if (c == '+') {
      foundSignals.add('-');
     } else {
      foundSignals.add('+');
     }
    }
    results.add(foundSignals);
   }
   return;
  }

  currSignals.add('-');

  checkSum(currSignals, number - operations[indexNextOperation], indexNextOperation + 1);
  currSignals.remove(currSignals.size() - 1);

  if (indexNextOperation > 0) {
   currSignals.add('+');
   checkSum(currSignals, number + operations[indexNextOperation], indexNextOperation + 1);
   currSignals.remove(currSignals.size() - 1);
  }
 }
}
