package com.data.structure;

import javax.xml.bind.ValidationEvent;

class Vertex {
	public char label;
	public boolean wasVisited;

	public Vertex(char label) {
		this.label = label;
		wasVisited = false;
	}
}

class Graph {
	private final int MAX_VERT = 20;
	private Vertex[] vertexList;
	private int[][] adjMat;
	private int nVerts;
	private Queue queue;
	private Stack stack;

	public Graph() {
		vertexList = new Vertex[MAX_VERT];
		adjMat = new int[MAX_VERT][MAX_VERT];
		nVerts = 0;
		for (int i = 0; i < MAX_VERT; i++) {
			for (int j = 0; j < MAX_VERT; j++) {
				adjMat[i][j] = 0;
			}

		}
		queue = new Queue();
		stack = new Stack();
	}

	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}

	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	public void bfs() {
		vertexList[0].wasVisited = true;
		displayVertex(0);
		queue.insert(0);
		int v2;
		while (!queue.isEmpty()) {
			int v = queue.remove();
			while ((v2 = getAdjUnvisitedVertex(v)) != -1) {
				vertexList[v2].wasVisited = true;
				displayVertex(v2);
				queue.insert(v2);
			}
		}

		for (int j = 0; j < nVerts; j++) // reset flags
		{
			vertexList[j].wasVisited = false;
		}

	}

	public void dfs() {
		vertexList[0].wasVisited = true;
		displayVertex(0);
		stack.push(0);
		while (!stack.isEmpty()) {
			int v = getAdjUnvisitedVertex(stack.peek());
			if (v != -1) {
				vertexList[v].wasVisited = true;
				displayVertex(v);
				stack.push(v);
			} else {
				stack.pop();
			}
		}
		for (int j = 0; j < nVerts; j++) // reset flags
		{
			vertexList[j].wasVisited = false;
		}

	}

	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}

	public int getAdjUnvisitedVertex(int v) {
		for (int j = 0; j < nVerts; j++) {
			if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
				return j;
		}
		return -1;

	}
}

public class BFSDFSDemo {

	public static void main(String[] args) {
		Graph theGraph = new Graph();
		theGraph.addVertex('A'); // 0 (start for dfs)
		theGraph.addVertex('B'); // 1
		theGraph.addVertex('C'); // 2
		theGraph.addVertex('D'); // 3
		theGraph.addVertex('E'); // 4

		theGraph.addEdge(0, 1); // AB
		theGraph.addEdge(1, 2); // BC
		theGraph.addEdge(0, 3); // AD
		theGraph.addEdge(3, 4); // DE
		System.out.print("bfs Visits: ");
		theGraph.bfs(); // breadth-first search
		System.out.println();

		System.out.print("dfs Visits: ");
		theGraph.dfs(); // breadth-first search
		System.out.println();
	}

}
