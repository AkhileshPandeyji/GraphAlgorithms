package prog;

import java.util.ArrayList;
import java.util.Scanner;

public class PerfectFriends {
	
	static class Edge{
		int src;
		int nbr;
		Edge(int s,int n){
			this.src = s;
			this.nbr = n;
		}
	}
	
	public static ArrayList<ArrayList<Integer>> getAllConnectedComponents(ArrayList<Edge> graph[]) {
		boolean visited[] = new boolean[graph.length];
		ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

		for (int i = 0; i < graph.length; i++) {
			if (visited[i] == false) {
				ArrayList<Integer> comp = new ArrayList<>();
				getCC(graph, i, comp, visited);
				comps.add(comp);
			}
		}
		return comps;
	}

	public static void getCC(ArrayList<Edge> graph[], int src, ArrayList<Integer> comp, boolean visited[]) {
		visited[src] = true;
		comp.add(src);

		for (Edge e : graph[src]) {
			if (visited[e.nbr] == false)
				getCC(graph, e.nbr, comp, visited);
		}

	}
	
	public static int clubPairing(ArrayList<ArrayList<Integer>> comps) {
		int pairs = 0;
		int sum = 0;
		for(int i=0;i<comps.size()-1;i++) {
			sum = 0;
			for(int k=i+1;k<comps.size();k++) {
				sum+=comps.get(k).size();
			}
			for(int j=0;j<comps.get(i).size();j++) {
				pairs+= sum;
			}
		}
		return pairs;
	}

	public static void main(String args[]) throws Exception {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int k = scn.nextInt();
		
		ArrayList<Edge> graph[] = new ArrayList[n];
		
		for(int i=0;i<graph.length;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<k;i++) {
			int src = scn.nextInt();
			int dest = scn.nextInt();
			graph[src].add(new Edge(src,dest));
			graph[dest].add(new Edge(dest,src));
		}
		
		System.out.println(clubPairing(getAllConnectedComponents(graph)));
		
		
	}

}
