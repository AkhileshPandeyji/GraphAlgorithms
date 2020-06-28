package prog;

import java.util.ArrayList;
import java.util.Scanner;

public class GraphCreationIntroduction {
	static class Edge<T>{
		T src;
		T dest;
		int wt;
		Edge(T s,T d,int w){
			this.src = s;
			this.dest = d;
			this.wt = w;
		}
	}
	public static void main(String[] args) {
	
		Scanner scn = new Scanner(System.in);
		int vtces = scn.nextInt();
		
		ArrayList<Edge<Integer>> graph[] = new ArrayList[vtces];
		
		for(int i=0;i<graph.length;i++) {
			graph[i] = new ArrayList<>();
		}
		
		graph[0].add(new Edge<Integer>(0,1,10));
		graph[0].add(new Edge<Integer>(0,3,40));
		
		graph[1].add(new Edge<Integer>(1,0,10));
		graph[1].add(new Edge<Integer>(1,2,10));
		
		graph[2].add(new Edge<Integer>(2,1,10));
		graph[2].add(new Edge<Integer>(2,3,10));
		
		graph[3].add(new Edge<Integer>(3,0,40));
		graph[3].add(new Edge<Integer>(3,2,10));
		graph[3].add(new Edge<Integer>(3,4,5));
		
		graph[4].add(new Edge<Integer>(4,3,5));
		graph[4].add(new Edge<Integer>(4,5,10));
		graph[4].add(new Edge<Integer>(4,6,10));
		
		graph[5].add(new Edge<Integer>(5,4,10));
		graph[5].add(new Edge<Integer>(5,6,10));
		
		graph[6].add(new Edge<Integer>(6,4,10));
		graph[6].add(new Edge<Integer>(6,5,10));
		
		
		
		
		for(int i=0;i<graph.length;i++) {
			System.out.print(i+"->");
			for(Edge<Integer> e:graph[i]) {
				System.out.print(e.dest+" @ "+e.wt+", ");
			}
			System.out.println(".");
		}
		
		scn.close();
	}
}
