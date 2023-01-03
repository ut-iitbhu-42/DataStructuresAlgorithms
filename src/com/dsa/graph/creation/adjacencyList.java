package com.dsa.graph.creation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class adjacencyList {

    public static void main(String[] args){

        // input for no of vertices and edges
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();
        int edges = scanner.nextInt();

        // input for edge details i.e., 1 2 => edge exist btwn 1 & 2
        int edgeArr[][] = new int[edges][2];
        for(int i=0; i<edges; i++){
            edgeArr[i][0] = scanner.nextInt();
            edgeArr[i][1] = scanner.nextInt();
        }

        createAdjacencyList(vertices, edges, edgeArr);
    }

    // static method is like a utility or helper
    // static doesn't depend on the object instance
    // static method can be utilized without object creation
    static void createAdjacencyList(int vertices, int edges, int edgeArr[][]){

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        System.out.println("\nInitializing Adjacency List");
        for(int i=0; i<=vertices; i++)
            adjList.add(new ArrayList<>());
        printAdjacencyList(adjList);

        System.out.println("\nCreating Adjacency List");
        for(int i=0; i<edges; i++)
            addEdges(adjList, edgeArr[i][0], edgeArr[i][1]);

        printAdjacencyList(adjList);
    }

    static void addEdges(ArrayList<ArrayList<Integer>> adjList, int sourceVertex, int destinationVertex){
        adjList.get(sourceVertex).add(destinationVertex);
        adjList.get(destinationVertex).add(sourceVertex);
    }

    static void printAdjacencyList(ArrayList<ArrayList<Integer>> adjList){
        int len = adjList.size(); // it will be equal to the vertices+1
        for(int i=0; i<len; i++){
            System.out.println(i + "->" + adjList.get(i));
        }
    }

}
