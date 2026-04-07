import java.util.*;
import java.io.*;


public class BJ15686_chiken_delivery {
	
	static int N , M ;
	static int minDis;
	static int distance;
	static ArrayList<int[]> houseList = new ArrayList<>();
	static ArrayList<int[]> chickenList = new ArrayList<>();
	
	static int [] picked;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	Scanner sc = new Scanner(System.in);
	
	N = sc.nextInt();
	M = sc.nextInt();
	
	
	minDis = Integer.MAX_VALUE;
	picked = new int[M];
	
	
	
	
	for (int i = 0 ; i < N ; i++) {
		
		for (int j = 0 ; j < N ; j++) {
			
			int val = sc.nextInt();
			if (val == 1) houseList.add(new int [] {i,j});
			else if (val ==2) chickenList.add(new int [] {i,j});
			
		}
	}
		
	dfs(0,0);

	System.out.println(minDis);
	
	
	}
	
	
	public static void dfs(int depth, int index) {
		
		if (depth == M) {
			
			calculate();
			return;
			
		}
		
		for (int i = index; i < chickenList.size(); i++)	{
			
			picked[depth] = i;
			dfs(depth +1, index +1);
			
		}
	
	}
	
	
	public static void calculate() {
		
		int distance = 0;
		
		for (int[] h : houseList ) {
			
			int minHtoC = Integer.MAX_VALUE;
			
			for (int id : picked) {
				
				int[] c = chickenList.get(id);
				
				int dis = Math.abs(c[0] - h[0]) + Math.abs(c[1] - h[1]);
				if (minHtoC > dis) minHtoC = dis;
				
				
			}
			
			distance += minHtoC;
			
		}
		
		
		if (minDis > distance) minDis = distance;
		
	}
	
}




