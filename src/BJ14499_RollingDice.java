import java.util.*;
import java.io.*;

public class BJ14499_RollingDice {

	
	static int N, M, x, y, O;
	static int[][] map;
	static int[] order;
	static int[] dx = {0,0,0,-1,1};
	static int[] dy = {0,1,-1,0,0};
	static int[] dice = {0,0,0,0,0,0}; 
	
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		O = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		order = new int[O];
		
		
		for (int i =0; i< N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j =0; j<M; j++) {
				
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}

		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int i =0; i< O; i++) {
			
			order[i] = Integer.parseInt(st.nextToken());
			
		}
		
		for (int i =0; i< O; i++) {
			
			
				
				// 현재 명령 가져오기
				int currOrder = order[i];
				
				// 이동하기
				int nx = x + dx[currOrder];
				int ny = y + dy[currOrder];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				x = nx;
				y = ny;
				
				roll(currOrder);
				
				if( map[x][y] == 0) {
					
					map[x][y] = dice[5];
					
				} else {
					
					dice[5] = map[x][y];
					map[x][y] = 0;
					
				}
				
				
				System.out.println(dice[0]);

		}
			
		

	}

	
	
	static public void roll(int dir) {
		
		int [] next = dice.clone();
			
		if (dir ==1) {
			
			dice[0] = next[3];
			dice[1] = next[0];
			dice[3] = next[5];
			dice[5] = next[1];

		}
		else if (dir == 2) {
			
			dice[0] = next[1];
			dice[1] = next[5];
			dice[3] = next[0];
			dice[5] = next[3];

		}
		else if (dir == 3) {
			
			dice[0] = next[2];
			dice[2] = next[5];
			dice[4] = next[0];
			dice[5] = next[4];

		}
		else if (dir == 4) {
			
			dice[0] = next[4];
			dice[2] = next[0];
			dice[4] = next[5];
			dice[5] = next[2];

		}

	}

}
