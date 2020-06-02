/*
https://www.urionlinejudge.com.br/judge/pt/problems/view/1799
BIANCA LIMA SANTOS 
GABRIEL ESTAVARINGO FERREIRA 
MARIANA SILVA SANTANA
*/

import java.util.*;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int graphSize = sc.nextInt();
            int edges = sc.nextInt();
            if (graphSize == 0) {
                return;
            }
            Graph graph = new Graph(graphSize);
            HashMap<String, Integer> dicionario = new HashMap<>();

            int contador = 0;
            sc.nextLine();
            for (int i = 0; i < edges; i++) {
                String linha = sc.nextLine();
                String[] pontos = linha.split(" ");
                
                int src = 0;
                int dest = 0;
                int distance = 1;
                
                if(dicionario.containsKey(pontos[0])){
                    src = dicionario.get(pontos[0]);
                }else{
                    dicionario.put(pontos[0], contador);
                    src = contador;
                    contador++;
                }
                
                if(dicionario.containsKey(pontos[1])){
                    dest = dicionario.get(pontos[1]);
                }else{
                    dicionario.put(pontos[1], contador);
                    dest = contador;
                    contador++;
                }

                graph.adjList.get(src).add(new Edge(dest, distance));
                graph.adjList.get(dest).add(new Edge(src, distance));
            }



            int start = dicionario.get("Entrada");
            int destiny = dicionario.get("*");


            int distance = djikstra(start, destiny, graph);

            start = dicionario.get("*");
            destiny = dicionario.get("Saida");
            
            graph.clear();
            
            distance += djikstra(start, destiny, graph);
            

            System.out.println(distance);

        }
        sc.close();
    }
    
    
    public static int djikstra(int start, int destiny, Graph graph){
        PriorityQueue < Node > pq = new PriorityQueue(graph.size, new SortByDistance());

        Node node = new Node(start, 0);
        pq.add(node);

        while (pq.size() > 0) {
            Node currNode = pq.poll();
            graph.visited[currNode.id] = 1;

            if (currNode.id == destiny) {
                break;
            }

            List < Edge > edgeList = graph.adjList.get(currNode.id);

            for (Edge edge: edgeList) {
                if (graph.visited[edge.dest] == -1) {
                    int distanceTo = currNode.distance + edge.distance;
                    Node nextNode = new Node(edge.dest, distanceTo);
                    if (graph.distance[nextNode.id] == -1) {
                        pq.add(nextNode);
                        graph.distance[nextNode.id] = distanceTo;
                        graph.source[nextNode.id] = currNode.id;
                    } else if (graph.distance[edge.dest] > distanceTo) {
                        pq.remove(nextNode);
                        pq.add(nextNode);
                        graph.distance[edge.dest] = distanceTo;
                        graph.source[nextNode.id] = currNode.id;
                    }
                }
            }
        }
        
        return graph.distance[destiny];
    }

    public static class Graph {
        public ArrayList < ArrayList < Edge >> adjList;
        public int[] distance;
        public int[] visited;
        public int[] source;
        public int size;

        public Graph(int size) {
            this.adjList = new ArrayList < ArrayList < Edge >> (size);
            this.distance = new int[size];
            this.visited = new int[size];
            this.source = new int[size];
            this.size = size;
            for (int i = 0; i < size; i++) {
                this.distance[i] = -1;
                this.visited[i] = -1;
                this.adjList.add(new ArrayList < Edge > ());
            }
        }
        
        public void clear(){
            for (int i = 0; i < size; i++) {
                this.distance[i] = -1;
                this.visited[i] = -1;
            }
        }
    }

    public static class Edge {
        public int dest;
        public int distance;

        public Edge(int dest, int distance) {
            this.dest = dest;
            this.distance = distance;
        }
    }


    public static class Node {
        public int id;
        public int distance;

        public Node(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }

        @Override
        public boolean equals(Object o) {
            Node node = (Node) o;
            return this.id == node.id;
        }
    }


    public static class SortByDistance implements Comparator < Node > {
        public int compare(Node a, Node b) {
            return a.distance - b.distance;
        }
    }
}
