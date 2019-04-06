/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

import java.util.*;

/**
 *
 * @author Waruna
 */
public class Graph {
//     DataStore dddddd= new DataStore();

    public String SendName1;
    private final Map<String, Vertex> graph; // mapping of vertex names to Vertex objects, built from a set of Edges

    /**
     * One edge of the graph (only used by Graph constructor)
     */
    public static class Edge {

        public final String START, END;
        public final int dist;

        public Edge(String START, String END, int dist) {
            this.START = START;
            this.END = END;
            this.dist = dist;
        }
    }

    public Graph(Edge[] edges) {
        graph = new HashMap<>(edges.length);
//        System.err.println(edges);
        // one pass to find all vertices
        for (Edge e : edges) {
            if (!graph.containsKey(e.START)) {
                graph.put(e.START, new Vertex(e.START));
//                System.err.println(e.START);
            }
            if (!graph.containsKey(e.END)) {
                graph.put(e.END, new Vertex(e.END));
//                   System.err.println(e.END);
            }
        }

        // another pass to set neighbouring vertices
        for (Edge e : edges) {
            graph.get(e.START).neighbours.put(graph.get(e.END), e.dist);
            graph.get(e.END).neighbours.put(graph.get(e.START), e.dist); // also do this
            // for an undirected graph
        }
    }

    /**
     * One vertex of the graph, complete with mappings to neighbouring vertices
     */
    public static class Vertex implements Comparable<Vertex> {

        public String SendName2;

        public final String name;
        public int dist = Integer.MAX_VALUE; // MAX_VALUE assumed to be infinity
        public Vertex previous = null;
        public final Map<Vertex, Integer> neighbours = new HashMap<>();

        public Vertex(String name) {
            this.name = name;
//            for (Map.Entry Pair: neighbours.entrySet()){
//         System.out.println(Pair.getKey()+" : "+Pair.getValue());
//     }
        }

        int g = 0;

        public List<String> CityList = new ArrayList<String>();
        public List<String> TotalDist = new ArrayList<String>();

        public String TotalDistance;

        private void printPath() {

            Visible vbl = new Visible();

            List<String> Name = new ArrayList<String>();
            List<String> Dist = new ArrayList<String>();

            if (this == this.previous) {

                System.out.printf("%s", this.name);

            } else if (this.previous == null) {

                System.out.printf("%s(unreached)", this.name);
            } else {
                this.previous.printPath();

                TotalDistance = Integer.toString(this.dist);

                CityList.clear();
                TotalDist.clear();
                CityList.add(this.name);
                TotalDist.add(TotalDistance);
//                }

                System.out.printf(" -> %s(%d)", this.name, this.dist);

                Name.add(this.name);
                Dist.add(TotalDistance);
                vbl.GetNameDist(Name, Dist);

            }

            vbl.GetArray(CityList, TotalDist);

        }

        public int compareTo(Vertex other) {
            if (dist == other.dist) {
                return name.compareTo(other.name);
            }
            return Integer.compare(dist, other.dist);
        }

        @Override
        public String toString() {
            return "(" + name + ", " + dist + ")";
        }
    }

    /**
     * Builds a graph from a set of edges
     */
//    public Graph(Edge[] edges) {
//        graph = new HashMap<>(edges.length);
//        System.err.println(edges);
//        // one pass to find all vertices
//        for (Edge e : edges) {
//            if (!graph.containsKey(e.START)) {
//                graph.put(e.START, new Vertex(e.START));
//                System.err.println(e.START);
//            }
//            if (!graph.containsKey(e.END)) {
//                graph.put(e.END, new Vertex(e.END));
//                   System.err.println(e.END);
//            }
//        }
//        
//        // another pass to set neighbouring vertices
//        for (Edge e : edges) {
//            graph.get(e.START).neighbours.put(graph.get(e.END), e.dist);
//            graph.get(e.END).neighbours.put(graph.get(e.START), e.dist); // also do this
//            // for an undirected graph
//        }
//    }
    /**
     * Runs dijkstra using a specified source vertex
     */
//}
//public class dijkstra{
    public void dijkstra(String startName) {
        if (!graph.containsKey(startName)) {
//			System.err.printf("Graph doesn't contain start vertex \"%s\"\n", startName);

            Visible vsbl = new Visible();

            vsbl.ErrMassage("Start city not available");

            return;
        }
        final Vertex source = graph.get(startName);
        NavigableSet<Vertex> q = new TreeSet<>();
        // set-up vertices
        for (Vertex v : graph.values()) {
            v.previous = v == source ? source : null;
            v.dist = v == source ? 0 : Integer.MAX_VALUE;
            q.add(v);
        }
        dijkstra(q);
    }

    /**
     * Implementation of dijkstra's algorithm using a binary heap.
     */
    private void dijkstra(final NavigableSet<Vertex> q) {
        Vertex u, v;
        while (!q.isEmpty()) {
            u = q.pollFirst(); // vertex with shortest distance (first iteration will return source)
            if (u.dist == Integer.MAX_VALUE) {
                break; // we can ignore u (and any other remaining vertices) since they are unreachable
            }			// look at distances to each neighbour
            for (Map.Entry<Vertex, Integer> a : u.neighbours.entrySet()) {
                v = a.getKey(); // the neighbour in this iteration
                final int alternateDist = u.dist + a.getValue();
                if (alternateDist < v.dist) { // shorter path to neighbour found
                    q.remove(v);
                    v.dist = alternateDist;
                    v.previous = u;
                    q.add(v);
                }
            }
        }
    }

    /**
     * Prints a path from the source to the specified vertex
     */
    public void printPath(String endName) {
        if (!graph.containsKey(endName)) {
//			System.err.printf(" \"%s\"\n", endName);
            Visible vsbl = new Visible();
            vsbl.ErrMassage("Destination city not available");
            return;
        }
        graph.get(endName).printPath();
        System.out.println();
    }

    /**
     * Prints the path from the source to every vertex (output order is not
     * guaranteed)
     */
    public void printAllPaths() {

        for (Vertex v : graph.values()) {

//            v.printPath();
            System.err.println(graph.get("a"));

        }

    }

    public void RemoveCity(String A) {
        graph.remove(A);
        graph.size();

    }

    public void AddCity(String A) {
     graph.get("a").neighbours.put(graph.get("c"), 5);
     
     
     
     
//     graph.
//        Graph.Edge[] GRAPH = {
//            new Graph.Edge("a", "z", 8),
//            new Graph.Edge("z", "h", 11),};
//        graph.size();

    }

    public void Update(String CityA, String CityB, int Distance) {
//     graph.containsValue(1);
//        System.err.println(graph.containsValue(1));
//        System.out.println();
//     graph.put(A, null)
//        Vertex v = null;
//         Vertex c = null;

//        graph.replace("a", v, c);
//        graph.clear();
//     for (Map.Entry Pair: graph.entrySet()){
//         System.out.println(Pair.getKey()+" : "+Pair.getValue());
//       graph.put("a", new Vertex("z"));
        graph.get(CityA).neighbours.put(graph.get(CityB), Distance);
        graph.get(CityB).neighbours.put(graph.get(CityA), Distance);

//        

//     }
    }

}
