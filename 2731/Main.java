/*
Programação de Viagem
https://www.urionlinejudge.com.br/judge/pt/problems/view/2731
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

            for (int i = 0; i < edges; i++) {
                int src = sc.nextInt();
                int dest = sc.nextInt();
                int distance = sc.nextInt();

                graph.adjList.get(src).add(new Edge(dest, distance));
                graph.adjList.get(dest).add(new Edge(src, distance));
            }

            int start = sc.nextInt();
            int destiny = 1;

            PriorityQueue < Node > pq = new PriorityQueue(graphSize, new SortByDistance());

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

            int totalDistance = graph.distance[1];

            ArrayList < Integer > path = new ArrayList < > ();

            int id = destiny;
            while (id != start) {
                path.add(0, id);
                id = graph.source[id];
            }
            path.add(0, start);

            StringBuilder sb = new StringBuilder();

            for (int i: path) {
                sb.append(" " + i);
            }

            if (totalDistance < 120) {
                System.out.println("Will not be late. Travel time - " + totalDistance + " - best way -" + sb);
            } else {
                int late = totalDistance - 120;
                System.out.println("It will be " + late + " minutes late. Travel time - " + totalDistance + " - best way -" + sb);
            }

        }
        sc.close();
    }

    public static class Graph {
        public ArrayList < ArrayList < Edge >> adjList;
        public int[] distance;
        public int[] visited;
        public int[] source;

        public Graph(int size) {
            this.adjList = new ArrayList < ArrayList < Edge >> (size);
            this.distance = new int[size + 1];
            this.visited = new int[size + 1];
            this.source = new int[size + 1];
            for (int i = 0; i <= size; i++) {
                this.distance[i] = -1;
                this.visited[i] = -1;
                this.adjList.add(new ArrayList < Edge > ());
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
