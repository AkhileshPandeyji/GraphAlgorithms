package prog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * 
 * Djikstras Algorithm is nothing but Breadth First Search implemented with PriorityQueue rather than 
 * Simple Queue
 * 
 */



public class DjikstrasAlgorithmShortestPathInWeights {
	static class Edge {
		int src;
		int nbr;
		int wt;

		Edge(int src, int nbr, int wt) {
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}
	
	static class Pair implements Comparable<Pair>{
		int vtx;
		String psf;
		int wsf;
		
		Pair(int v,String p,int w){
			this.vtx = v;
			this.psf = p;
			this.wsf = w;
		}
		
		public int compareTo(Pair o) {
			return this.wsf - o.wsf;
		}		
	}
	
	public static void shortestPath(ArrayList<Edge> graph[],int src) {
		boolean visited[] = new boolean[graph.length];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(src,""+src,0));
		
		while(pq.size()>0) {
			Pair rem = pq.remove();
			if(visited[rem.vtx] == false) {
				visited[rem.vtx] = true;
				System.out.println(rem.vtx+" via "+rem.psf+" @ "+rem.wsf);
				for(Edge e:graph[rem.vtx]) {
					if(visited[e.nbr] == false) {
						pq.add(new Pair(e.nbr,rem.psf+e.nbr,rem.wsf+e.wt));
					}
				}
			}
		}
		
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
		shortestPath(graph,src);

	}
}
