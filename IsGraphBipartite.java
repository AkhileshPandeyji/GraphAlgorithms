package prog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class IsGraphBipartite {
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
	
	static class Pair{
		int vtx;
		int level;
		Pair(int v,int l){
			this.vtx = v;
			this.level = l;
		}
	}

	public static boolean isBipartite(ArrayList<Edge> graph[]) {
		HashMap<Integer,Integer> visited = new HashMap<>();
		for(int v=0;v<graph.length;v++) {
			if(visited.containsKey(v) == false) {
				if(isBipartite(graph,visited,v) == false) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean isBipartite(ArrayList<Edge> graph[],HashMap<Integer,Integer> visited,int src) {
		
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(src,0));
		
		while(q.size()>0) {
			Pair rem = q.remove();
			if(visited.containsKey(rem.vtx)) {
				if(rem.level%2 != visited.get(rem.vtx)%2) {
					return false;
				}
			}
			else {
				visited.put(rem.vtx,rem.level);
			}
			
			for(Edge e:graph[src]) {
				if(visited.containsKey(e.nbr) == false) {
					q.add(new Pair(e.nbr,rem.level+1));
				}
			}			
		}
		return true;
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

		System.out.println(isBipartite(graph));
	}
}
