package prog;

import java.util.ArrayList;
import java.util.Scanner;

import prog.GraphCreationIntroduction.Edge;

/*
 * 
7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
 * 
 * 
 */

public class GraphCreationAndDisplayCustomInputs {
	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		int vtces = scn.nextInt();
		int edges = scn.nextInt();
		
		ArrayList<Edge<Integer>> graph[] = new ArrayList[vtces];
		for(int i=0;i<graph.length;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<edges;i++) {
			int src = scn.nextInt();
			int dest = scn.nextInt();
			int wt = scn.nextInt();
			
			graph[src].add(new Edge<Integer>(src,dest,wt));
			graph[dest].add(new Edge<Integer>(dest,src,wt));
			
		}
		
		for(int i=0;i<graph.length;i++) {
			System.out.print(i+"->");
			for(Edge<Integer> e: graph[i]) {
				System.out.print(e.dest+"@"+e.wt+",");
			}
			System.out.println(".");
		}
		
	}
}
