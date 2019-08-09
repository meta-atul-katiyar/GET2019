import java.util.*;

public class UndirectedGraphImplement implements UndirectedGraph {

	int[][] Vertex;
	int numOfVertices;
	boolean[] matCheck;
	int matLen;
	Set<Integer> verticesSet = new HashSet<Integer>();
	Set<Integer> reachableVer = new HashSet<Integer>();
	Set<Integer> visitedVertices = new HashSet<Integer>();

	/**
	 * @param verticesArr
	 */
	UndirectedGraphImplement(int[] verticesArr) {
		this.numOfVertices = verticesArr.length;
	}

	/**
	 * @param weightMatrix
	 */
	public void insertWeightInMat(int[][] weightMatrix) {
		this.matLen = weightMatrix.length;
		this.Vertex = weightMatrix;
	}

	/**
	 * @param startVertex
	 * @return true if connected else false
	 */
	private boolean dfs(int startVertex) {
		this.matCheck = new boolean[matLen];
		int index = 0;
		StackImplement stack = new StackImplement();
		while ((Vertex[index][0] != startVertex && Vertex[index][1] != startVertex)) {
			index++;
			if (index >= matLen) {
				throw new AssertionError();
			}
		}
		verticesSet.add(startVertex);
		stack.push(startVertex);
		while (!stack.isEmpty()) {
			int topElement = stack.pop();
			index = 0;
			for (; index < matLen; index++) {
				int tempIndex = index;
				while (matCheck[tempIndex]) {
					tempIndex++;
					if (tempIndex >= matLen - 1) {
						break;
					}
				}
				if (tempIndex < matLen) {
					if (Vertex[tempIndex][1] == topElement
							&& Vertex[tempIndex][0] == topElement)
						reachableVer.add(topElement);
					else if (Vertex[tempIndex][0] == topElement) {
						int num = Vertex[tempIndex][1];
						if (verticesSet.add(num)) {
							reachableVer.add(num);
							stack.push(num);
						}
						matCheck[tempIndex] = true;
					} else if (Vertex[tempIndex][1] == topElement) {
						int num = Vertex[tempIndex][0];
						if (verticesSet.add(num)) {
							reachableVer.add(num);
							stack.push(num);
						}
						matCheck[tempIndex] = true;
					}
				}
				index = tempIndex;
			}
		}
		if(verticesSet.size() == numOfVertices) {
			return true;
		}
		return false;
	}
	/* (non-Javadoc)
	 * @see UndirectedGraph#isConnected()
	 */
	public boolean isConnected() {
		return dfs(3);
	}

	/* (non-Javadoc)
	 * @see UndirectedGraph#reachable(int)
	 * return set of vertices reachable through given vertex
	 */
	public Set<Integer> reachable(int a) {
		dfs(a);
		for (int i : reachableVer)
			System.out.println(i);
		return reachableVer;
	}

	/**
	 * print matCheck boolean array
	 */
	public void matCheckPrint() {
		for (int i = 0; i < matLen; i++)
			System.out.print(matCheck[i] + " ");
	}

	/**
	 * @param minSpanTree
	 * @param verArr
	 * @return true if cycle exist
	 */
	public boolean findCycle(HashMap<Integer[], Integer> minSpanTree,
			Integer[] verArr) {
		if (minSpanTree.size() == 0) {
			return false;
		}
		Integer[] tempVerArr = new Integer[] { verArr[0], verArr[1] };
		int count = 0;
		for (Integer[] arr : minSpanTree.keySet()) {
			if (tempVerArr[1] == arr[0]) {
				tempVerArr[1] = arr[1];
				count++;
			} else if (tempVerArr[1] == arr[1]) {
				tempVerArr[1] = arr[0];
				count++;
			}
			if (count < 1) {
				if (tempVerArr[0] == arr[0]) {
					tempVerArr[1] = arr[1];
					count++;
				} else if (tempVerArr[0] == arr[1]) {
					tempVerArr[1] = arr[0];
					count++;
				}
			}
			if (count > 1
					&& (verArr[0] == tempVerArr[1] || verArr[1] == tempVerArr[1])) {
				return true;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see UndirectedGraph#mst()
	 * return a map of mst
	 */
	public HashMap<Integer[], Integer> mst() {
		this.matCheck = new boolean[matLen];
		HashMap<Integer[], Integer> minSpanTree = new HashMap<Integer[], Integer>();

		while (minSpanTree.size() != numOfVertices - 1) {
			int min = Integer.MAX_VALUE, tempIndex = -1, flag = 0;
			Integer[] verArr = new Integer[2];
			for (int index = 0; index < matLen; index++) {
				if (!matCheck[index] && Vertex[index][2] < min) {
					verArr[0] = Vertex[index][0];
					verArr[1] = Vertex[index][1];
					min = Vertex[index][2];
					tempIndex = index;
					flag = 1;
				}
			}
			if ((verArr[0] != verArr[1])) {
				if (findCycle(minSpanTree, verArr) == false) {
					minSpanTree.put(verArr, min);
				}
				matCheck[tempIndex] = true;
			} else {
				if(tempIndex != -1)
					matCheck[tempIndex] = true;
			}
			min = Integer.MAX_VALUE;

		}
		for (Integer[] num : minSpanTree.keySet()) {
			System.out.println(num[0] + " " + num[1]);
		}
		return minSpanTree;
	}
	
	/**
	 * @param Vertex
	 * @return normal matrix
	 */
	public int[][] adjMat(int[][]Vertex){
		int adMat[][] = new int[numOfVertices][numOfVertices];
		for(int row = 0; row< numOfVertices; row++){
			for(int column = 0; column< numOfVertices; column++){
				adMat[row][column] = 0;
			}
		}
		for(int count = 0; count < matLen; count++){
			adMat[Vertex[count][0]-1][Vertex[count][1]-1] = Vertex[count][2];
			adMat[Vertex[count][1]-1][Vertex[count][0]-1] = Vertex[count][2];
		}
		return adMat;
	}
	/**
	 * @param adMat
	 */
	public void printAdj(int[][] adMat){
		for(int row = 0; row< numOfVertices; row++){
			for(int column = 0; column< numOfVertices; column++){
				System.out.print(adMat[row][column]);
			}
			System.out.println();
		}
	}

	/**
	 * @param dist
	 * @param sptSet
	 * @return index of minimum distance
	 */
	public int minDistance(int[][] dist, boolean[] sptSet) {
		int min = Integer.MAX_VALUE, min_index = -1;
		for (int count = 0; count < numOfVertices; count++)
			if (sptSet[count] == false && dist[count][0] <= min) {
				min = dist[count][0];
				min_index = count;
			}
		return min_index;
	}

	/**
	 * @param src
	 * @return return distance matrix
	 */
	public int[][] dijkstra(int src) {
		int[][] adMat = adjMat(Vertex);
		int dist[][] = new int[numOfVertices][2];
		boolean sptSet[] = new boolean[numOfVertices];

		for (int count = 0; count < numOfVertices; count++) {
			dist[count][0] = Integer.MAX_VALUE;
			dist[count][1] = -1;
		}
		dist[src][0] = 0;
		for (int count = 0; count < numOfVertices - 1; count++) {
			int u = minDistance(dist, sptSet);
			sptSet[u] = true; 
			for(int count1 = 0; count1 < numOfVertices; count1++){
				if(!sptSet[count1] && adMat[u][count1]!=0 && dist[u][0]+adMat[u][count1] < dist[count1][0]){
					dist[count1][0] = dist[u][0]+adMat[u][count1];
					dist[count1][1] = u;
				}
			}
		}
		return dist;
	}

	/* (non-Javadoc)
	 * @see UndirectedGraph#shortestPath(int, int)
	 * return string of shortest path
	 */
	public String shortestPath(int a, int b) {
		int src = a-1, des = b-1;
		int[][] dist = dijkstra(src);
		String path = Integer.toString(des+1);
		int  tempb = des;
		while(tempb != -1 && tempb != src){
			path = Integer.toString(dist[tempb][1]+1)+"-"+path;
			tempb = dist[tempb][1];
		}
		System.out.println(path);
		return path;
	}

	public static void main(String[] args) {
		int[] verticesArray = new int[] { 1, 2, 3, 4, 5, 6 };
		UndirectedGraphImplement ugi = new UndirectedGraphImplement(verticesArray);
		int[][] verMat = new int[][] {
				{ 1, 2, 2 },
				{ 1, 3, 3 },
				{ 2, 3, 4 },
				// {3,3,6},
				{ 3, 4, 6 },
				{ 4, 5, 8 },
				{ 4, 6, 5 },
				{ 5, 5, 4 },
				{ 5, 6, 1 }
			};
		ugi.insertWeightInMat(verMat);
		// System.out.println(ugi.isConnected());
		// ugi.reachable(3);
		//ugi.mst();
		ugi.shortestPath(1,5);
	}
}
