/**
 * File name: Graph.java
 * =====================
 * This class implements graph.
 */
package eulerhamilton;

import java.io.*;
import java.util.*;

public class Graph {
	private int vertexes; // number of vertexes
	private int edges; // number of edges
	private LinkedList<Integer>[] adj; // an array of vertexes

	@SuppressWarnings("unchecked")
	public Graph(int vertexes) {
		this.vertexes = vertexes;
		adj = (LinkedList<Integer>[]) new LinkedList[vertexes];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	@SuppressWarnings("unchecked")
	public Graph(BufferedReader bReader) {
		String line = null;
		String[] arr = null;
		int v1 = 0;
		int v2 = 0;
		try {
			vertexes = Integer.parseInt(bReader.readLine());
			edges = Integer.parseInt(bReader.readLine());
			adj = (LinkedList<Integer>[]) new LinkedList[vertexes];
			for (int i = 0; i < adj.length; i++) {
				adj[i] = new LinkedList<Integer>();
			}
			while (true) {
				line = bReader.readLine();
				if (line == null)
					break;
				arr = line.split(" ");
				v1 = Integer.parseInt(arr[0]);
				v2 = Integer.parseInt(arr[1]);
				addEdge(v1, v2);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Adds edge between vertex 1 and vertex 2
	 * 
	 * @param v1
	 *            first vertex
	 * @param v2
	 *            second vertex
	 */
	public void addEdge(int v1, int v2) {
		adj[v1].add(v2);
		adj[v2].add(v1);
	}

	/**
	 * Degree of the given vertex
	 * 
	 * @param v
	 *            vertex which degree you want to know
	 * @return a degree of the given vertex
	 */
	public int degree(int v) {
		return adj[v].size();
	}

	public boolean hasEdge(int v1, int v2) {
		return adj[v1].contains(v2);
	}
	
	/**
	 * Returns number of vertexes
	 * 
	 * @return number of vertexes
	 */
	public int getVertexes() {
		return vertexes;
	}

	/**
	 * Returns number of edges
	 * 
	 * @return number of edges
	 */
	public int getEdges() {
		return edges;
	}

	/**
	 * Returns adjacent vertexes regarding to the given one
	 * 
	 * @return adjacent vertexes regarding to the given one
	 */
	public Iterable<Integer> adj(int v) {
		LinkedList<Integer> clone = new LinkedList<>();
		for (int n : adj[v]) {
			clone.add(n);
		}
		Collections.sort(clone);
		return clone;
	}
	
	@SuppressWarnings("unchecked")
	public LinkedList<Integer>[] copyVertexes(){
		LinkedList<Integer>[] clone = (LinkedList<Integer>[]) new LinkedList[vertexes];
		for(int i = 0; i < clone.length; i++) {
			if(clone[i] == null)
				clone[i] = new LinkedList<>();
			for(int n : adj[i]) {
				clone[i].add(n);
			}
		}
		return clone;
	}

	/**
	 * Prints out (twice) edges of the graph
	 */
	public void print() {
		for (int v = 0; v < vertexes; v++) {
			for (int w : adj(v)) {
				System.out.println(v + "-" + w);
			}
		}
	}
}
