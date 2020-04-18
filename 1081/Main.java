/*
DFSr
https://www.urionlinejudge.com.br/judge/pt/problems/view/1081
BIANCA LIMA SANTOS 
GABRIEL ESTAVARINGO FERREIRA 
MARIANA SILVA SANTANA
*/

import java.util.*;

public class Main {

 public static void main(String args[]) {
  Scanner sc = new Scanner(System.in);

  int testCases = sc.nextInt();

  for (int j = 1; j <= testCases; j++) {
   if (j > 1) {
    System.out.print("\n" + "Caso " + j + ":");
   } else {
    System.out.print("Caso " + j + ":");
   }
   int graphSize = sc.nextInt();

   int edges = sc.nextInt();

   Graph graph = new Graph(graphSize);

   for (int i = 0; i < edges; i++) {
    int src = sc.nextInt();
    int dest = sc.nextInt();
    graph.adjList.get(src).add(dest);
   }


   for (int i = 0; i < graphSize; i++) {
    if (graph.visited[i] == -1 && graph.adjList.get(i).size() > 0) {
     pathR(graph, i, "  ");
     System.out.println();
    }
   }

  }

  System.out.println();
 }

 public static void pathR(Graph graph, int node, String blankSpace) {
  graph.visited[node] = 0;
  for (int i = 0; i < graph.adjList.size(); i++) {
   if (graph.adjList.get(node).contains(i)) {
    if (graph.visited[i] == -1) {
     System.out.print("\n" + blankSpace + node + "-" + i + " pathR(G," + i + ")");
     pathR(graph, i, blankSpace + "  ");
    } else {
     System.out.print("\n" + blankSpace + node + "-" + i);
    }
   }
  }
 }

 public static class Graph {
  public ArrayList < ArrayList < Integer >> adjList;
  public int[] visited;

  public Graph(int size) {
   this.adjList = new ArrayList < ArrayList < Integer >> (size);
   this.visited = new int[size + 1];
   for (int i = 0; i <= size; i++) {
    this.visited[i] = -1;
    this.adjList.add(new ArrayList < Integer > ());
   }
  }
 }
}
