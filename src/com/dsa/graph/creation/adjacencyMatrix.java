package com.dsa.graph.creation;

import java.util.Scanner;

public class adjacencyMatrix {

    public static void main(String[] args){

        /* Input no of Vertices n Edges  */
        System.out.println("\n Enter no of vertices and edges");
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();
        int edges = scanner.nextInt();

        //Input of Edges & collectively creating adjacency matrix
        int adjMatrix[][] = new int[vertices+1][vertices+1]; // taken 1 extra space (v+1), to avoid doing -1 everytime

        System.out.println("\n Enter all the edges \n");
        for(int i=0; i<edges; i++){
            // input of an edge, i.e., 2 3
            int startVertex = scanner.nextInt();
            int endVertex = scanner.nextInt();
            adjMatrix[startVertex][endVertex] = 1;
            adjMatrix[endVertex][startVertex] = 1;
        }

        //print adjacency matrix
        System.out.println("\n Here's the Adjacency Matrix => \n");
        for(int i=0; i<vertices+1; i++ ){
            for(int j=0; j< vertices+1;  j++){
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.print("\n");
        }

    }

}
