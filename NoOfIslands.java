package prog;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NoOfIslands {
	
	public static void getCC(int[][] area,boolean[][] visited,int x,int y) {
		visited[x][y] = true;
		
		if(x-1 >= 0 && visited[x-1][y] == false && area[x-1][y] == 0)
		getCC(area,visited,x-1,y);
		
		if(y+1 < area[0].length && visited[x][y+1] == false && area[x][y+1] == 0)
		getCC(area,visited,x,y+1);
		
		if(y-1 >= 0 && visited[x][y-1] == false && area[x][y-1] == 0)
		getCC(area,visited,x,y-1);
		
		if(x+1 < area.length && visited[x+1][y] == false && area[x+1][y] == 0)
		getCC(area,visited,x+1,y);
	}
	
	public static int findIslands(int area[][]) {
		boolean visited[][] = new boolean[area.length][area[0].length];
		int count = 0;
		
		for(int i=0;i<area.length;i++) {
			for(int j=0;j<area[0].length;j++) {
				if(visited[i][j] == false && area[i][j] == 0) {
					getCC(area,visited,i,j);
					count++;
				}
			}
		}
		
		
		return count;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[m][n];

		for (int i = 0; i < arr.length; i++) {
			String parts = br.readLine();
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
			}
		}
		
		System.out.println(findIslands(arr));

	}
}
