import java.util.HashMap;
import java.util.Set;


interface UndirectedGraph {
	boolean isConnected();
	Set<Integer> reachable(int a);
	HashMap<Integer[], Integer> mst();
	String shortestPath(int a, int b);
}
