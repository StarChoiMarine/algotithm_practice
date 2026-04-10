import java.util.*;
import java.io.*;

public class BJ14500_Tetromino {

	
	
	static int M,N;
	static int[][] map;
	static int Max = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		
		
		for (int i=0; i<M;i++) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<N;j++) {
				
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
			
		}
		
		// for 문으로 돌면서 다 순회
		
		for (int i=0; i<M;i++) {
					
				
					
				for(int j=0;j<N;j++) {
						
					if (j<N-3) line(i,j);
					if (i<M-3) line2(i,j);
					if (i<M-1 && j <N-1) square(i,j);
					
					if (i < M-2 && j < N-1) {
						nieun1(i,j);
						nieun2(i,j);
					}
					
					if (i < M-1 && j < N-2) {
						nieun3(i,j);
						nieun4(i,j);
					}
					
					if (i < M-2 && j < N-1) {
						thunder1(i,j);
					}
					
					if (i < M-1 && j < N-2) {
						thunder2(i,j);
					}
					
					if (i < M-2 && j < N-1) {
						woo1(i,j);
						woo2(i,j);
					}
					
					if (i < M-1 && j < N-2) {
						woo3(i,j);
						woo4(i,j);
					}
					
//					
					
//					
					
					
						
				}
					
		}
		
		
		System.out.println(Max);
		
		
	}
	
	public static void line(int x, int y){
		
		int sum = 0;
	
		for (int a =0; a < 4; a++) {
				
				sum += map[x][y+a];
				if (Max < sum) Max = sum;
			}

		sum = 0;
		
	}
	
	public static void line2(int x, int y){
		
		int sum = 0;
	
		for (int a =0; a < 4; a++) {
				
			sum += map[x+a][y];
			if (Max < sum) Max = sum;
		}

		sum = 0;
		
	}
	
	public static void square(int x, int y){
		
		int sum = 0;
			
		sum = map[x][y]+ map[x+1][y+1] + map[x][y+1]+ map[x+1][y];
		if (Max < sum) Max = sum;
		
		sum =0;
		
	}
	
	// 대칭 필
	public static void nieun1(int x, int y){
		
		int sum = 0;
		
		sum = map[x][y]+ map[x+1][y] + map[x+2][y]+ map[x+2][y+1];
		if (Max < sum) Max = sum;
		
		sum = map[x][y+1]+ map[x+1][y+1] + map[x+2][y]+ map[x+2][y+1];
		if (Max < sum) Max = sum;
		
		
		sum =0;
		
		
	}
	public static void nieun2(int x, int y){
		int sum = 0;
		
		sum = map[x][y]+ map[x][y+1] + map[x+1][y+1]+ map[x+2][y+1];
		if (Max < sum) Max = sum;
		
		sum = map[x][y]+ map[x][y+1] + map[x+1][y]+ map[x+2][y];
		if (Max < sum) Max = sum;
		
		sum =0;
		
		
	}
	public static void nieun3(int x, int y){
		
		int sum = 0;
		
		sum = map[x][y+2]+ map[x+1][y] + map[x+1][y+1]+ map[x+1][y+2];
		if (Max < sum) Max = sum;
		
		sum = map[x][y]+ map[x+1][y] + map[x+1][y+1]+ map[x+1][y+2];
		if (Max < sum) Max = sum;
		
		
		sum =0;
		
	}
	public static void nieun4(int x, int y){
		
		int sum = 0;
		
		sum = map[x][y]+ map[x+1][y] + map[x][y+1]+ map[x][y+2];
		if (Max < sum) Max = sum;
		
		sum = map[x][y]+ map[x+1][y+2] + map[x][y+1]+ map[x][y+2];
		if (Max < sum) Max = sum;
		
		sum =0;
		
		
	}
	
	public static void thunder1(int x, int y){
		
		int sum = 0;
		
		sum = map[x][y]+ map[x+1][y] + map[x+1][y+1]+ map[x+2][y+1];
		if (Max < sum) Max = sum;
		
		sum = map[x][y+1]+ map[x+1][y] + map[x+1][y+1]+ map[x+2][y];
		if (Max < sum) Max = sum;
		
		sum =0;
		
		
	}
	
	public static void thunder2(int x, int y){
		
		int sum = 0;
		
		sum = map[x][y+1]+ map[x][y+2] + map[x+1][y]+ map[x+1][y+1];
		if (Max < sum) Max = sum;
		
		sum = map[x][y+1]+ map[x][y] + map[x+1][y+2]+ map[x+1][y+1];
		if (Max < sum) Max = sum;
		
		sum =0;
		
		
	}
	
	public static void woo1(int x, int y){
		
		int sum = 0;
		
		sum = map[x][y]+ map[x+1][y+1] + map[x+1][y]+ map[x+2][y];
		if (Max < sum) Max = sum;
		
		sum =0;
		
		
		
	}
	public static void woo2(int x, int y){
		
		int sum = 0;
		
		sum = map[x][y+1]+ map[x+1][y] + map[x+1][y+1]+ map[x+2][y+1];
		if (Max < sum) Max = sum;
		
		sum =0;
		
		
	}
	public static void woo3(int x, int y){
		
		int sum = 0;
		
		sum = map[x][y]+ map[x][y+1] + map[x][y+2]+ map[x+1][y+1];
		if (Max < sum) Max = sum;
		
		sum =0;
		
	}
	public static void woo4(int x, int y){
		
		int sum = 0;
		
		sum = map[x][y+1]+ map[x+1][y] + map[x+1][y+1]+ map[x+1][y+2];
		if (Max < sum) Max = sum;
		
		sum =0;
		
	}
	
	
	
	
	
	
	

}
