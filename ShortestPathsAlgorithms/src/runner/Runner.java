package runner;

import java.io.File;

import graph.Graph;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File(System.getProperty("user.home")+"\\dijkstra_3.txt");
		Graph graph = new Graph();
		graph.readGraph(file);
		int[] distances = new int[graph.size()];
		graph.runDijkstra(0,distances);
	}

}
