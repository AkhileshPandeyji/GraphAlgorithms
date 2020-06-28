package prog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class OrderOfCompilation {
	   static class Edge {
		      int src;
		      int nbr;

		      Edge(int src, int nbr) {
		         this.src = src;
		         this.nbr = nbr;
		      }
		   }
	   		
	   		public static void orderOfComp(ArrayList<Edge> graph[]) {
	   			boolean visited[] = new boolean[graph.length];
	   			Stack<Integer> st = new Stack<>();
	   			for(int v = 0;v<graph.length;v++) {
	   				if(visited[v] == false) {
	   					orderOfComp(graph,v,visited,st);
	   				}	   				
	   			}
	   			
	   			for(int i=st.size()-1;i>=0;i--) {
	   				System.out.println(st.get(i));
	   			}
	   			
	   		}
	   		
	   		public static void orderOfComp(ArrayList<Edge> graph[],int src,boolean visited[],Stack<Integer> st) {
	   			visited[src] = true;
	   			for(Edge e : graph[src]) {
	   				if(visited[e.nbr] == false) {
	   					orderOfComp(graph,e.nbr,visited,st);
	   				}
	   			}
	   			
	   			st.push(src);
	   		}
	   		
		   public static void main(String[] args) throws Exception {
		      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		      int vtces = Integer.parseInt(br.readLine());
		      ArrayList<Edge>[] graph = new ArrayList[vtces];
		      for (int i = 0; i < vtces; i++) {
		         graph[i] = new ArrayList<>();
		      }

		      int edges = Integer.parseInt(br.readLine());
		      for (int i = 0; i < edges; i++) {
		         String[] parts = br.readLine().split(" ");
		         int v1 = Integer.parseInt(parts[0]);
		         int v2 = Integer.parseInt(parts[1]);
		         graph[v1].add(new Edge(v1, v2));
		      }

		      orderOfComp(graph);
		   }

}
