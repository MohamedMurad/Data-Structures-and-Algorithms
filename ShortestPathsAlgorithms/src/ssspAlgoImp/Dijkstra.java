package ssspAlgoImp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

import graph.Edge;
import validation.Exceptions;

public class Dijkstra {

	final int MAX = Integer.MAX_VALUE;
	final int MIN = Integer.MIN_VALUE;
	private int dist[], parent[], orders[];
	private int n, orderIndex;

	public Dijkstra() {
		super();
	}

	public void runDijkstra(ArrayList<ArrayList<Edge>> graph, int src) {

		n = graph.size();
		dist = new int[n];
		parent = new int[n];
		orders = new int[n];
		orderIndex = 0;
		PriorityQueue<Edge> q = new PriorityQueue<>();

		Arrays.fill(dist, MAX);
		Arrays.fill(parent, MIN);
		dist[src] = 0;
		q.add(new Edge(-1, src, 0));

		while (!q.isEmpty()) {
			Edge edge = q.poll();

			if (edge.getW() > dist[edge.getTo()]) {
				continue;
			}

			parent[edge.getTo()] = edge.getFrom();

			for (int i = 0; i < graph.get(edge.getTo()).size(); i++) {
				Edge child = graph.get(edge.getTo()).get(i);
				if (child.getW() < 0) {
					Exceptions.getInstance().throwNegWeightNotAllowed();
				}
				if (dist[child.getTo()] > dist[child.getFrom()] + child.getW()) {
					child.setW(dist[child.getFrom()] + child.getW());
					dist[child.getTo()] = child.getW();
					q.add(child);
				}
			}
			
			orders[orderIndex++] = edge.getTo();
		}
	}

	public int[] getDistances() {
		return dist;
	}

	public int[] getPath() {
		return parent;
	}
	
	public int[] getOrders(){
		return orders;
	}
	
	public void printResults(){
		System.out.println("Distances: "+Arrays.toString(dist));
		System.out.println("parent: "+Arrays.toString(parent));
		System.out.println("orders: "+Arrays.toString(orders));
	}
}