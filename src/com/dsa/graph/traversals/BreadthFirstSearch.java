package com.dsa.graph.traversals;

import java.util.*;

public class BreadthFirstSearch {

    /*
     * Implement this BFS(adjList) function
     * adjList => adjacency List of a grpah is given to you
     */
    static void BFS(ArrayList<ArrayList<Integer>> adjList, int source){
        // pretty similar to Level Order traversal
        // since graph bi-directional, i.e., go to-n-fro from each other | use visited[] for that
        // mark visit a node, when it is inside queue | need not to visit again, i.e., dont push to a queue when it is already in processing or inside the queue

        System.out.println("\n-----------Starting Breadth First Search Algorithm-----------------\n");

        int vertices = adjList.size();
        boolean visited[] = new boolean[vertices+1];
        for(int i=0; i<vertices; i++){
            visited[i] = false;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;

        while(!queue.isEmpty()){
            int top = queue.poll();
            System.out.println("Processing node no = " + top);
            int sizeOfConnectedNodes = adjList.get(top).size();

            for(int i=0; i<sizeOfConnectedNodes; i++){
                if(!visited[adjList.get(top).get(i)]){
                    queue.add(adjList.get(top).get(i));
                    visited[adjList.get(top).get(i)] = true;
                }
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

        // input no of vertices and edges
        System.out.println("\n Input no of Vertices & Edges: \n");

        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();
        int edges = scanner.nextInt();

        //input of edgeArr & creating adjacency list
        System.out.println("\n Input Edges: \n");

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<vertices+1; i++)
            adjList.add(new ArrayList<Integer>());

        for(int i=0; i<edges; i++){
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            addEdges(adjList, source, destination);
        }

        //print adjacency list of graph
        System.out.println("\n Showing the adjacency list \n");

        printGraph(adjList);

        /*
        *
        * Write the BFS at BFS(adjList, source)
        *
         */
        BFS(adjList, 1);
    }

    static void addEdges(ArrayList<ArrayList<Integer>> adjList, int source, int destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> adjList){
        int vertices = adjList.size();
        for(int i=0; i<vertices; i++) {
            System.out.println(i + "->" + adjList.get(i));
        }
    }

}
