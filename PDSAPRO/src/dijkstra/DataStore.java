/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijkstra;

//package dijkstra;
//import java.awt.Event;
//import java.io.*;
//import java.util.*;
////import javafx.util.Pair;
//import java.util.Comparator;
//import java.util.LinkedList;
//import java.util.PriorityQueue;
/**
 *
 * @author Waruna
 */
public class DataStore {

	public static String START;
	public static String END;

	public static  Graph.Edge[]  GRAPH = {
		   new Graph.Edge( "a", "h", 8),
		   new Graph.Edge("b", "h", 11),
		   new Graph.Edge("b", "c", 8),
		   new Graph.Edge("c", "i", 2),
		   new Graph.Edge("c", "d", 7),
		   new Graph.Edge("c", "f", 4),
		   new Graph.Edge("d", "f", 14),
		   new Graph.Edge("e", "f", 10),
		   new Graph.Edge("f", "g", 2),
		   new Graph.Edge("g", "h", 1),
		   new Graph.Edge("i", "g", 6),
		   new Graph.Edge("h", "i", 8),

		   new Graph.Edge("h", "a", 8),
		   new Graph.Edge("h", "b", 11),
		   new Graph.Edge("c", "b", 8),
		   new Graph.Edge("i", "c", 2),
		   new Graph.Edge("d", "c", 7),
		   new Graph.Edge("f", "c", 4),
		   new Graph.Edge("f", "d", 14),
		   new Graph.Edge("f", "e", 10),
		   new Graph.Edge("g", "f", 2),
		   new Graph.Edge("h", "g", 1),
		   new Graph.Edge("g", "i", 6),
		   new Graph.Edge("i", "h", 8),
	};

	public void GET( String A, String B) {  this.START = A;  this.END = B; }

//	public static String STYY;
//
//	public void Display(String START) {
//		this.STYY = START;
//		System.out.println(START);
//
//
//	}

}

