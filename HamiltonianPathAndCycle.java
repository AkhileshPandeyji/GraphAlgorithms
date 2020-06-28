package prog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class HamiltonianPathAndCycle {
	static class Edge {
	      int src;
	      int nbr;
	      int wt;

	      Edge(int src, int nbr,int wt) {
	         this.src = src;
	         this.nbr = nbr;
	         this.wt = wt;
	      }
	   }
	   
	   public static void hamPathAndCycle(ArrayList<Edge> graph[],int osrc,int vtx,String psf,HashSet<Integer> visited) {
		   if(visited.size() == graph.length-1) {
			   psf = psf+vtx;
			   boolean cycle = false;
			   
			   for(Edge e:graph[vtx]) {
				   if(e.nbr == osrc) {
					   cycle = true;
				   }
			   }
			   if(cycle) {
				   System.out.println(psf+"*");
			   }
			   else {
				   System.out.println(psf+".");
			   }
			   
		   }
		   visited.add(vtx);
		   for(Edge e:graph[vtx]) {
			   if(visited.contains(e.nbr) == false) {
				   hamPathAndCycle(graph,osrc,e.nbr,psf+vtx,visited);
			   }
		   }
		   visited.remove(vtx);
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
	         int wt = Integer.parseInt(parts[2]);
	         graph[v1].add(new Edge(v1, v2, wt));
	         graph[v2].add(new Edge(v2, v1, wt));
	      }
	      int src = Integer.parseInt(br.readLine());
	      hamPathAndCycle(graph,src,src,"",new HashSet<Integer>());
	   }
}
