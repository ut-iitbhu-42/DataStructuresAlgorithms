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

        //initialize space for storing Graph
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<=vertices; i++)
            adjList.add(new ArrayList<>());

        //input of all the edges
        for(int i=0; i<edges; i++){
            int startVertex = scanner.nextInt();
            int endVertex = scanner.nextInt();

            adjList.get(startVertex).add(endVertex);
            adjList.get(endVertex).add(startVertex);
        }

        // printing the adjacency List
            for(int i=0; i<=vertices; i++){
                System.out.println("Vertex" + i + " -> " + adjList.get(i));
            }

    }


}
