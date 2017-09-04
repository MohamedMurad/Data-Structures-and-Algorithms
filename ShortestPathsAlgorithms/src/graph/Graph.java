package graph;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import eg.edu.alexu.csd.filestructure.graphs.IGraph;
import ssspAlgoImp.Dijkstra;

public class Graph implements IGraph {

	ArrayList<ArrayList<Edge>> graph;
	int gSize;

	public Graph() {
		super();
		graph = new ArrayList<ArrayList<Edge>>();
		gSize = 0;
	}

	@Override
	public void readGraph(File file) {
		// TODO Auto-generated method stub
		int edges;
		Scanner scan;
		try {
			scan = new Scanner(file);
			gSize = scan.nextInt();
			edges = scan.nextInt();
			for (int i = 0; i < gSize; i++) {
				ArrayList<Edge> neighbors = new ArrayList<>();
				graph.add(neighbors);
			}
			for (int i = 0; i < edges; i++) {
				int from = scan.nextInt();
				int to = scan.nextInt();
				int w = scan.nextInt();
				graph.get(from).add(new Edge(from, to, w));
				}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return gSize;
	}

	// why this method needed!.
	@Override
	public ArrayList<Integer> getVertices() {
		// TODO Auto-generated method stub
		ArrayList<Integer> vertices = new ArrayList<>();
		for (int i = 0; i < gSize; i++) {
			vertices.add(i);
		}
		return vertices;
	}

	@Override
	public ArrayList<Integer> getNeighbors(int v) {
		// TODO Auto-generated method stub
		ArrayList<Integer> neighbors = new ArrayList<>();
		ArrayList<Edge> neighborsEdge = new ArrayList<>(graph.get(v));
		for (int i = 0; i < neighborsEdge.size(); i++) {
			neighbors.add(neighborsEdge.get(i).getTo());
		}
		return neighbors;
	}

	@Override
	public void runDijkstra(int src, int[] distances) {
		// TODO Auto-generated method stub
		Dijkstra dijkstra = new Dijkstra();
		dijkstra.runDijkstra(graph, src);
		dijkstra.printResults();
	}

	@Override
	public ArrayList<Integer> getDijkstraProcessedOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean runBellmanFord(int src, int[] distances) {
		// TODO Auto-generated method stub
		return false;
	}
}
