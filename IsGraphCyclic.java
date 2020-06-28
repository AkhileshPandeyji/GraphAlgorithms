package prog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class IsGraphCyclic {
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
	
	public static boolean isCyclic(ArrayList<Edge> graph[]) {
		boolean visited[] = new boolean[graph.length];
		
		for(int vt = 0;vt<graph.length;vt++) {
			if(!visited[vt]) {
				if(isCyclic(graph,visited,vt)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean isCyclic(ArrayList<Edge> graph[],boolean visited[],int src) {
		
		Queue<Integer> q = new ArrayDeque<>();
		q.add(src);
		
		while(q.size()>0) {
			int remVtx = q.remove();
			if(visited[remVtx] == false) {
				visited[remVtx] = true;
				for(Edge e: graph[remVtx]) {
					if(visited[e.nbr] == false) {
						q.add(e.nbr);
					}
				}
			}
			else {
				return true;
			}					
		}
		return false;
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

		System.out.println(isCyclic(graph));
	}
}
