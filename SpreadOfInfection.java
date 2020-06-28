package prog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class SpreadOfInfection {
	  static class Edge {
	      int src;
	      int nbr;

	      Edge(int src, int nbr) {
	         this.src = src;
	         this.nbr = nbr;
	      }
	   }
	  	static class Pair{
	  		int vtx;
	  		int time;
	  		
	  		Pair(int v,int t){
	  			this.vtx = v;
	  			this.time = t;
	  		}	  		
	  	}
	  	
	  	public static int countInfected(ArrayList<Edge>graph[],int src,int tot) {
	  		boolean visited[] = new boolean[graph.length];
	  		int count = 0;
	  		Queue<Pair> q = new ArrayDeque<>();
	  		
	  		q.add(new Pair(src,1));
	  		
	  		while(q.size() > 0) {
	  			Pair rem = q.remove();
	  			if(visited[rem.vtx] == false) {
	  				count++;
	  				visited[rem.vtx] = true;
	  				for(Edge e: graph[rem.vtx]) {
	  					if(visited[e.nbr] == false && rem.time+1<=tot) {
	  						q.add(new Pair(e.nbr,rem.time+1));
	  					}
	  				}
	  			}	  			
	  		}
	  		return count;  		
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
	         graph[v2].add(new Edge(v2, v1));
	      }

	      int src = Integer.parseInt(br.readLine());
	      int t = Integer.parseInt(br.readLine());
	      
	      System.out.println(countInfected(graph,src,t));
	   }

}
