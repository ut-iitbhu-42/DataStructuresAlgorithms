package com.dsa.graph.traversals;

import java.util.*;

public class DepthFirstSearch {

    static void dfs(ArrayList<ArrayList<Integer>> adjList, int source){
        int vertices = adjList.size();
        boolean visited[] = new boolean[vertices];
        for(int i=0; i<vertices; i++)
            visited[i] = false;

        System.out.print("DFS : ");
        dfsUtil(adjList, source, visited);
    }

    static void dfsUtil(ArrayList<ArrayList<Integer>> adjList, int source, boolean[] visited){

        visited[source] = true;
        System.out.print(source + " ");
        for(Integer vertex : adjList.get(source)){
            if(!visited[vertex]){
                dfsUtil(adjList, vertex, visited);
            }
        }

    }

    public static void main(String[] args){

        /*
         *  test input ver n edges : 6 8
         *  all edges: 1 2 1 3 1 4 2 3 3 6 3 5 5 6 4 5
         *
         * test output: 1 2 3 4 6 5
         *
         */

        System.out.println("\nEnter no of vertices and edges : ");
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();
        int edges = scanner.nextInt();

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        // take input of edgeArrays & create Adjacency List
        createAdjacencyList(adjList, edges, vertices);

        // Print the Graph
        printAdjList(adjList);

        // Do the DFS
        System.out.println("Enter the source vertex for DFS : ");
        int sourceVertex = scanner.nextInt();
        dfs(adjList, sourceVertex);

    }

    static void createAdjacencyList(ArrayList<ArrayList<Integer>> adjList, int edges, int vertices){

        for (int i=0; i<vertices+1; i++)
            adjList.add(new ArrayList<>());

        System.out.println("\nEnter edge details : ");

        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<edges; i++){
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            adjList.get(source).add(destination);
            adjList.get(destination).add(source);
        }
    }

    static void printAdjList(ArrayList<ArrayList<Integer>> adjList){
        System.out.println("\nPrinting Adjacency List : ");

        int i=0;
        for(ArrayList<Integer> list: adjList)
            System.out.println(i++ + "->" + list);
    }
}
