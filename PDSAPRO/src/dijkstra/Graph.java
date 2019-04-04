/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;
import java.util.*;
//import javafx.util.Pair;

/**
 *
 * @author Waruna
 */
public class Graph {
public String  SendName1;
	private final Map<String, Vertex> graph; // mapping of vertex names to Vertex objects, built from a set of Edges

	/** One edge of the graph (only used by Graph constructor) */

	public static class Edge {
		public final String START, END;
		public final int dist;

		public Edge(String START, String END, int dist) {
			this.START = START;
			this.END = END;
			this.dist = dist;
		}
	}

	/** One vertex of the graph, complete with mappings to neighbouring vertices */

	public  class Vertex implements Comparable<Vertex> {
             public String  SendName2;
            
		public final String name;
		public int dist = Integer.MAX_VALUE; // MAX_VALUE assumed to be infinity
		public Vertex previous = null;
		public final Map<Vertex, Integer> neighbours = new HashMap<>();

		public Vertex(String name) {
			this.name = name;
		}

		private void printPath() {
                    
                    
                    Visible vbl = new Visible();
//                    public String
 int sum = 0;
List<String> Name = new ArrayList<String>();
List<String> Dist = new ArrayList<String>();

// String[] cars;


			if (this == this.previous) {
//                            System.err.println("**");
				System.out.printf("%s", this.name);
                                
			} else if (this.previous == null) {
//                            System.err.println("****");
				System.out.printf("%s(unreached)", this.name);
			} else {
				this.previous.printPath();
//                                System.err.println("******");
				System.out.printf(" -> %s(%d)", this.name, this.dist);
//                               SendName2=this.name;
                                  
                                  String Distance= Integer.toString(this.dist); 
                                  
//                                  vbl.JLabel.setText(Integer.toString(this.dist));
                                  
                                   final int i=0;
                                   
                       
                                  
                                  
                                  Name.add(this.name);
                                  Dist.add(Distance);
                                  vbl.GDF(Name, Dist);
//                                   System.err.println("******");

//                                 vbl.GDF(this.name, Distance);
                                 
//				System.err.println("80");
			}
//                        System.err.println(this.dist);
//                         System.err.println("89");
		}
                
                
                
                
                
//                public String Send(String A,String B){
//                    
//                    
//                    
//                    return "";
//                }
                

		public int compareTo(Vertex other) {
			if (dist == other.dist)
				return name.compareTo(other.name);
			return Integer.compare(dist, other.dist);
		}

		@Override
		public String toString() {
			return "(" + name + ", " + dist + ")";
		}
	}

	/** Builds a graph from a set of edges */
	public Graph(Edge[] edges) {
		graph = new HashMap<>(edges.length);
		// one pass to find all vertices
		for (Edge e : edges) {
			if (!graph.containsKey(e.START))
				graph.put(e.START, new Vertex(e.START));
			if (!graph.containsKey(e.END))
				graph.put(e.END, new Vertex(e.END));
		}
		// another pass to set neighbouring vertices
		for (Edge e : edges) {
			graph.get(e.START).neighbours.put(graph.get(e.END), e.dist);
			// graph.get(e.END).neighbours.put(graph.get(e.START), e.dist); // also do this
			// for an undirected graph
		}
	}

	/** Runs dijkstra using a specified source vertex */
	public void dijkstra(String startName) {
		if (!graph.containsKey(startName)) {
//			System.err.printf("Graph doesn't contain start vertex \"%s\"\n", startName);
                        
                                Visible vsbl = new Visible();
                                vsbl.ErrMassage("Graph doesn't contain start vertex");
////                                vsbl.showMessageDialog(null, "Graph doesn't contain start vertex", "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
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

	/** Implementation of dijkstra's algorithm using a binary heap. */
	private void dijkstra(final NavigableSet<Vertex> q) {
		Vertex u, v;
		while (!q.isEmpty()) {
			u = q.pollFirst(); // vertex with shortest distance (first iteration will return source)
			if (u.dist == Integer.MAX_VALUE)
				break; // we can ignore u (and any other remaining vertices) since they are unreachable
			// look at distances to each neighbour
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


        
	/** Prints a path from the source to the specified vertex */
	public void printPath(String endName) {
		if (!graph.containsKey(endName)) {
//			System.err.printf("Graph doesn't contain end vertex \"%s\"\n", endName);
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
//		System.err.println("50");
		for (Vertex v : graph.values()) {
//			System.err.println("60");
			v.printPath();
			System.out.println();
//			System.err.println("70");
		}
	}
        
        
        
        
        
        
        
        
        
        
        
        
}
    
    

