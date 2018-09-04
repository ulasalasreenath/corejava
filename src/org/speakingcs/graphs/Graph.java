package org.speakingcs.graphs;

import java.util.Stack;

public class Graph {

	private final int maxVertices = 20;
	private Vertex vertexList[];
	private int adjMatrix[][];
	
	private int vertexCount;
	private Stack theStack;
	
	public Graph()
	{
		vertexList = new Vertex[maxVertices];
		adjMatrix = new int[maxVertices][maxVertices];
		vertexCount = 0;
		
		for(int i = 0; i < maxVertices; i++)
		{
			for(int j = 0; j < maxVertices; j++)
			{
				adjMatrix[i][j] = 0;
			}
		}
		theStack = new Stack();
	}
	
	public void addVertex(char lab)
	{
		vertexList[vertexCount++] = new Vertex(lab);
	}
	
	public void addEdge(int start, int end)
	{
		adjMatrix[start][end] = 1;
		adjMatrix[end][start] = 1;
	}
	
	public void displayVertex(int v)
	{
		System.out.print(vertexList[v].label);
	}
	
	public void dfsRecursive()
	{
		dfsRecursive(0);
  	}
	
	public void dfsRecursive(int node)
	{
		System.out.print(vertexList[node].label);
		vertexList[node].visited = true;
		
		int v = getAdjUnvisitedVertex(node);
		
		while(v != -1)
		{
			dfsRecursive(v);
			v = getAdjUnvisitedVertex(node);
		}
	}
	
	public void dfs()
	{
		vertexList[0].visited = true;
		displayVertex(0);
		theStack.push(0);
		while(!theStack.isEmpty()) {
			int v = getAdjUnvisitedVertex((int)theStack.peek());
			
			if(v == -1)
			{
				theStack.pop();
			}else
			{
				vertexList[v].visited = true;
				displayVertex(v);
				theStack.push(v);
			}
		}
		
		for(int j = 0; j < vertexCount; j++)
		{
			vertexList[j].visited = false;
		}
	}

	private int getAdjUnvisitedVertex(int v) {
		
		for(int j = 0; j < vertexCount; j++)
		{
			if(adjMatrix[v][j] == 1 && vertexList[j].visited == false)
			{
				return j;
			}
		}
		return -1;
	}
}
