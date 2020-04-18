/*
See World
https://www.urionlinejudge.com.br/judge/pt/problems/view/1955
BIANCA LIMA SANTOS 
GABRIEL ESTAVARINGO FERREIRA 
MARIANA SILVA SANTANA
*/

import java.util.*;

public class Main {


 public static void main(String args[]) {
  Scanner sc = new Scanner(System.in);

  while (sc.hasNextInt()) {
   int numberOfNodes = sc.nextInt();

   int numberOfGroups = 0;

   int[][] adjMatrix = new int[numberOfNodes + 1][numberOfNodes + 1];

   Graph graph = new Graph(numberOfNodes);

   for (int i = 1; i <= numberOfNodes; i++) {
    for (int j = 1; j <= numberOfNodes; j++) {
     int edge = sc.nextInt();
     adjMatrix[i][j] = edge;
     if (edge == 1 && j != i) {
      graph.adjList.get(i).add(j);
     }
    }
   }

   for (int i = 1; i <= numberOfNodes; i++) {
    if (graph.available[i] == -1) {
     graph.available[i] = 0;
     graph.checked[i] = -1;
     for (int currNode: graph.adjList.get(i)) {
      if (graph.available[currNode] == -1) {
       boolean hasConnections = true;
       for (int nextNode: graph.adjList.get(i)) {
        if (adjMatrix[currNode][nextNode] != 1 && graph.checked[nextNode] == -1 && graph.available[nextNode] == -1) {
         hasConnections = false;
         break;
        }
       }
       if (hasConnections) {
        graph.available[currNode] = 0;
       } else {

        graph.checked[currNode] = 0;
       }
      }
     }
     numberOfGroups++;
     if (numberOfGroups > 2) {
      break;
     }
    }
   }


   if (numberOfGroups > 2) {
    System.out.println("Fail!");
   } else {
    System.out.println("Bazinga!");
   }

  }
  sc.close();
 }

 public static class Graph {
  public ArrayList < ArrayList < Integer >> adjList;
  public int[] available;
  public int[] checked;

  public Graph(int size) {
   this.adjList = new ArrayList < ArrayList < Integer >> (size);
   this.available = new int[size + 1];
   this.checked = new int[size + 1];
   for (int i = 0; i <= size; i++) {
    this.available[i] = -1;
    this.checked[i] = -1;
    this.adjList.add(new ArrayList < Integer > ());
   }
  }
 }
}
