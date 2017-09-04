package graph;

public class Edge implements Comparable<Edge>{
	
	private int from, to, w;
	
	public Edge(int from, int to, int w) {
		super();
		this.from = from;
		this.to= to;
		this.w = w;
	}
	
	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	@Override
	public int compareTo(Edge e) {
		return Integer.compare(this.w,e.w);
	}
}