package prog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BreadFirstTraversal {
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
		String psf;
		Pair(int vtx,String psf){
			this.vtx = vtx;
			this.psf = psf;
		}
	}
	
	public static void BFS(ArrayList<Edge> graph[],int src) {
		Queue<Pair> q = new ArrayDeque<>();
		boolean visited[] = new boolean[graph.length];
		q.add(new Pair(src,""+src));
		
		while(q.size()>0) {
			Pair remVtx = q.remove();
			if(visited[remVtx.vtx] == false) {
				visited[remVtx.vtx] = true;
				System.out.println(remVtx.vtx+"@"+remVtx.psf);
				
				for(Edge e : graph[remVtx.vtx]) {
					if(visited[e.nbr] == false)
					q.add(new Pair(e.nbr,remVtx.psf+e.nbr));
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
			graph[v1].add(new Edge(v1, v2));
			graph[v2].add(new Edge(v2, v1));
		}

		int src = Integer.parseInt(br.readLine());
		BFS(graph,src);
	}
}
