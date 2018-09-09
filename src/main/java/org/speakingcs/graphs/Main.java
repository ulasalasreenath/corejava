package org.speakingcs.graphs;

public class Main {

	public static void main(String[] args)
	{
		Graph g = new Graph();
		g.addVertex('A'); //0
		g.addVertex('B'); //1
		g.addVertex('C'); //2
		g.addVertex('D'); //3
		g.addVertex('E'); //4
		g.addVertex('F'); //5
		g.addVertex('G'); //6
		g.addVertex('H'); //7
		
		g.addEdge(0, 1); // A,B
		g.addEdge(1, 2); // B,C
		g.addEdge(1, 7); // B,H
		g.addEdge(2, 3); // C,D
		g.addEdge(2, 4); // C,E
		g.addEdge(4, 7); // E,H
		g.addEdge(4, 5); // E,F
		g.addEdge(4, 6); // E,G
		
		//g.dfs();
		g.dfsRecursive();
	}
}
