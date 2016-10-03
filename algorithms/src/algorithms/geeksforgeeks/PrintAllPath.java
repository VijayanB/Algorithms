package algorithms.geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPath {
	int node;
	List<Integer> adjList[];
	boolean visited[];
	int[] path;

	public PrintAllPath(int node) {
		this.node = node;
		adjList = new ArrayList[this.node];
		for (int i = 0; i < node; i++) {
			adjList[i] = new ArrayList<>();
		}
		this.visited = new boolean[this.node];
		path = new int[this.node];
	}

	public void addEdge(int s, int dest) {
		adjList[s].add(dest);
	}

	public void printPath(int source, int destination, int level) {
		path[level] = source;
		this.visited[source] = true;
		if (source == destination) {
			for (int i = 0; i <= level; i++) {
				System.out.print(path[i]);
			}
			System.out.println();

		} else {
			for (Integer s : adjList[source]) {
				if (this.visited[s] == false)
					printPath(s, destination, level + 1);
			}

		}
		this.visited[source] = false;
	}

	public static void main(String[] args) {
		PrintAllPath graph = new PrintAllPath(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(2, 0);
		graph.addEdge(2, 1);
		graph.addEdge(1, 3);

		// graph.printGraph();
		graph.printPath(2, 3, 0);
	}
}
