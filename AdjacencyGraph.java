import java.util.ArrayList;
import java.util.PriorityQueue;

public class AdjacencyGraph {

	private ArrayList<Vertex> vertices;

	public AdjacencyGraph() {
		vertices = new ArrayList<Vertex>();
	}

	public void addVertex(Vertex v) {
		vertices.add(v);
	}

	public void newEdge(Vertex from, Vertex to, Integer dist) {
		if (!(vertices.contains(from) && vertices.contains(to))) {
			System.out.println(" Vertex not found. ");
			return;
		}
		Edge newEdge = new Edge(from, to, dist);
		Edge newEdge2 = new Edge(to, from, dist);
	}

	public void printGraph() {
		Vertex currentv;
		for (int i = 0; i < vertices.size(); i++) {
			currentv = vertices.get(i);
			System.out.println(" Edges from Vertex: " + currentv.getName());
			for (int j = 0; j < currentv.getOutEdges().size(); j++) {
				Edge currentEdge = currentv.getOutEdges().get(j);
				System.out.println(
						" To " + currentv.getOutEdges().get(j).getToVertex().getName() + " distance: " + currentEdge.getWeight());

			}
			System.out.println(" ");
		}
	}

	// MST er kun de distancer som bliver hevet ud af Q
	public void PrimsMST() {

		// https://www.geeksforgeeks.org/min-heap-in-java/
		// https://codegym.cc/groups/posts/min-heap-in-java

		MinHeap<Vertex> Q = new MinHeap<>();

		// Vælger et arbitrært starting point her Arralyist (0)
		if (vertices.size() > 0)
			vertices.get(0).distance = 0;

		for (int i = 0; i < vertices.size(); i++) {
			Q.Insert(vertices.get(i));
		}

		// MST bliver lavet når den hiver en vertex ud, da den kun hiver den ud med den
		// korteste distance.
		// MST bliver "lavet" via predecessor en kant k og distance,

		int MST = 0;
		while (!Q.isEmpty()) {
			Vertex u = Q.extractMin();
			for (int k = 0; k < u.getOutEdges().size(); k++) {

				Vertex v = u.getOutEdges().get(k).getToVertex();

				if (u.getOutEdges().get(k).getWeight() < v.distance) {
						v.distance = u.getOutEdges().get(k).getWeight();
						v.predecessor = u;
						int pos = Q.getPosition(v);
						Q.decreasekey(pos);
					}
				}
			MST += u.distance; // Kun distance mellem de vertices vi har hevet ud
		}
		int finalPrice = MST * 100000;
		System.out.println("Weight of the MST is: " + MST + "km \n" + "The final price of the grid is: " + finalPrice + "kr \n");
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).predecessor != null)
				System.out.println(" parent " + vertices.get(i).predecessor.getName() + " to " + vertices.get(i).getName() + " EdgeWeight: " + vertices.get(i).getDistance());
		}
	}
}

class Vertex implements Comparable<Vertex> {
	private String name;
	private ArrayList<Edge> outEdges;
	Integer distance = Integer.MAX_VALUE;
	Vertex predecessor = null;
	Boolean visited = false;

	public Vertex getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}

	public Boolean getVisited() {
		return visited;
	}

	public void setVisited(Boolean visited) {
		this.visited = visited;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Edge> getOutEdges() {
		return outEdges;
	}

	public void setOutEdges(ArrayList<Edge> outEdges) {
		this.outEdges = outEdges;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Vertex(String ID) {
		this.name = ID;
		outEdges = new ArrayList<>();
	}

	public void addOutEdge(Edge outEdge) {
		outEdges.add(outEdge);
	}

	public int compareTo(Vertex o) {
		if (this.distance < o.distance) {
			return -1;
		}
		if (this.distance > o.distance) {
			return 1;
		}

		return 0;
	}
}

class Edge {
	private Vertex fromVertex;
	private Vertex toVertex;
	private Integer weight;

	public Vertex getFromVertex() {
		return fromVertex;
	}

	public void setFromVertex(Vertex fromVertex) {
		this.fromVertex = fromVertex;
	}

	public Vertex getToVertex() {
		return toVertex;
	}

	public void setToVertex(Vertex toVertex) {
		this.toVertex = toVertex;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Edge(Vertex from, Vertex to, Integer cost) {
		fromVertex = from;
		toVertex = to;
		weight = cost;
		from.addOutEdge(this);
	}

}