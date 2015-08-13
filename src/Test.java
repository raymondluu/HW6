import java.util.*;

public class Test {
	public static ArrayList<Edge> Kruskal(ArrayList<LinkedList<Edge>> graph)
	{
		ArrayList<Edge> edgeArrayList = new ArrayList<Edge>();
		PriorityQueue<Edge> edgeQueue = new PriorityQueue<Edge>(1, new EdgeComparator());
		//add your code here
		//edgeArrayList is used to store the chosen edges in MST
		//graph is stored in Adjacency List format. 
		//Here, the index of the ArrayList is corresponding to the vertex ID in a graph.
		//Each LinkedList represents the edge set incident on the vertex with ID of the index.
		int num_elements = graph.size();
		DisjointSets dj = new DisjointSets(num_elements);
		int root1 = 0;
		int root2 = 0;
		for (LinkedList<Edge> vertex : graph)
		{
			edgeQueue.addAll(vertex);
		}
		while(!edgeQueue.isEmpty())
		{
			Edge e = edgeQueue.remove();
			root1 = dj.find(e.v);
			root2 = dj.find(e.u);
			if (root1 != root2)
			{
				edgeArrayList.add(e);
				dj.union(root1, root2);
			}
		}
		return edgeArrayList;
	}
	public static void main(String args[])
	{
		//The following graph is a complete graph with four nodes of IDs: 0, 1, 2, 3
		ArrayList<LinkedList<Edge>> graph = new ArrayList<LinkedList<Edge>>();
		LinkedList<Edge> edges0 = new LinkedList<Edge>();//edge set incident on the vertex of ID 0
		LinkedList<Edge> edges1 = new LinkedList<Edge>();//edge set incident on the vertex of ID 1
		LinkedList<Edge> edges2 = new LinkedList<Edge>();//edge set incident on the vertex of ID 2
		LinkedList<Edge> edges3 = new LinkedList<Edge>();//edge set incident on the vertex of ID 3
		Edge e1 = new Edge(0, 1, 1);
		Edge e2 = new Edge(0, 2, 2);
		Edge e3 = new Edge(0, 3, 3);
		Edge e4 = new Edge(1, 2, 3);
		Edge e5 = new Edge(1, 3, 4);
		Edge e6 = new Edge(2, 3, 5);
		edges0.add(e1);
		edges0.add(e2);
		edges0.add(e3);
		edges1.add(e1);
		edges1.add(e4);
		edges1.add(e5);
		edges2.add(e2);
		edges2.add(e4);
		edges2.add(e6);
		edges3.add(e3);
		edges3.add(e5);
		edges3.add(e6);
		graph.add(edges0);
		graph.add(edges1);
		graph.add(edges2);
		graph.add(edges3);
		// test code
//		ArrayList<Edge> min_span_tree = Kruskal(graph);
//		for(Edge e : min_span_tree) {
//			System.out.println("Vertex 1: " + e.v);
//			System.out.println("Vertex 2: " + e.u);
//			System.out.println("Weight: " + e.weight);
//			System.out.println();
//		}
	}
}