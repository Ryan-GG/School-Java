import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Utility class providing some basic graph algorithms. (Based on an earlier lab
 * designed by John Bowers.)
 * 
 * @author Nathan Sprague && Ryan gross && Seth Walter
 * @version 12/4/20
 */

public class GraphAlgorithms {

	/**
	 * Return the out degree of vertex v.
	 */
	public static <T> int getOutDegreeOfVertex(Graph<T> graph, T vertex) {

	  return graph.neighbors(vertex).size();
	}

	/**
	 * Return the in degree of vertex v.
	 */
	public static <T> int getInDegreeOfVertex(Graph<T> graph, T vertex) {
	  int count = 0;
	  
	  for( T vert : graph.allNodes()) {
	    if(graph.hasEdge(vert, vertex)) {
	      count++;
	    }
	  }
	  
	  return count;
	}

	/**
	 * Returns true if the graph is connected. (This method should only be applied
	 * to undirected graphs.)
	 */
	public static <T> boolean isConnected(Graph<T> graph) {
		// FIRST IMPLEMENT THE DFS TRAVERSAL BELOW.

		// A graph is considered "connected" if every node is reachable from every other
		// node. We can check for connectedness by starting a traversal at an arbitrary
		// node. if all nodes are visited, then the graph was connected. If there are
		// any unvisited nodes then the graph was not connected.
	  @SuppressWarnings("unchecked")
    T[] temp = (T[]) graph.allNodes().toArray();
	  
	  HashMap<T, Boolean> map = GraphAlgorithms.DFS(graph, temp[0]);
	  
	  for(T vert : map.keySet()) {
	    
	    if(map.get(vert) == false) {
	      return false;
	    }
	  }
		return true;
	}

	/**
	 * Perform a DFS traversal of the provided graph starting at the indicated
	 * vertex. This method returns a HashMap indicating which nodes in the graph
	 * were visited during the traversal. Vertices that were visited will be mapped
	 * to true.
	 * 
	 * @param graph  The graph to traverse
	 * @param vertex The starting vertex
	 * @return A map indicating which vertices were visited
	 */
	public static <T> HashMap<T, Boolean> DFS(Graph<T> graph, T vertex) {

		// CREATE THE HASH MAP HERE.
	  HashMap<T, Boolean> temp = new HashMap<T,Boolean>();
		// INITIALIZE ALL VERTICES TO FALSE.
	  for( T vert : graph.allNodes()) {
	    temp.put(vert, false);
	    
	  }
		// THE ACTUAL TRAVERSAL WILL BE HANDLED IN THE HELPER.
	  DFSHelper(graph,vertex,temp);
		return temp;
	}

	/**
	 * Recursive DFS traversal.
	 */
	private static <T> void DFSHelper(Graph<T> graph, T vertex, HashMap<T, Boolean> visited) {

		// STEPS:
		// - MARK THE CURRENT VERTEX AS VISITED
	  visited.put(vertex, true);
		// - RECURSIVELY TRAVERSE ALL NON-VISITED NEIGHBORS
	  for(T next : graph.neighbors(vertex)) {
	    if(visited.get(next) == false) {
	    DFSHelper(graph,next,visited);
	    }
	  }

	}

}
