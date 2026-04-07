import java.util.*;
import java.io.*;


public class BJ14502_Laboratory {

	
	
	static int[][] map;
	static int N, M;
	static int maxSafety;

	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		maxSafety = 0;
		
		map = new int [N][M];
		
		for (int i = 0 ; i<N; i++) {
			for (int j =0; j<M;j++) {
				map[i][j] = sc.nextInt();
			}				
		}	
		// map 배열로 옮기기 완료	
		// 해야할 것 : 앞에서부터 탐색하면서 벽 만들기 -> dfs -> 함수로 구현하자
		
		dfs(0,0);
		
		System.out.println(maxSafety);

	}
	
	// 0  중에서 3개를 골라서 벽을 세우는 + 거기다가 완성됐을때 마다 bfs를 돌리는
	public static void dfs(int depth, int start) {
		
		if (depth == 3) {
			
			bfs();
			return;
		}
		
		for (int i = start; i < N*M; i++) {
				
				if (map[i/M][i%M] == 0) {
					
					map[i/M][i%M] = 1;
					dfs(depth+1, i+1);
					map[i/M][i%M] = 0; //  탐색 다 하고오면 다시 0으로 되돌려놓기
					
				}
				
			}
				
		}				
	
	
	
	public static void bfs() {
		
		int count = 0;
		int[][] m = new int [N][M];
		
		for (int r = 0; r<N ; r++) {
			for(int c = 0; c<M ; c++){
				
				m[r][c] = map[r][c];
				
			}
		}
		
		Queue<int[]> q = new LinkedList<>();

		
		for (int r = 0; r<N ; r++) {
			for(int c = 0; c<M ; c++){
				
				if ( m[r][c] == 2) {
					
					q.offer(new int [] {r,c});
					
				}
				
			}
	
		}
		
		while(!q.isEmpty()) {
			
			
			int[] curr = q.poll();
			int x = curr[0];
			int y = curr[1];
			
			
			for (int d =0; d<4;d++) {
				
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx >= 0 && nx < N && ny>= 0 && ny < M && m[nx][ny] == 0) {
				m[nx][ny] = 2;
				q.offer(new int[] {nx,ny});
				
				}
			}
		}
		
		for (int r = 0; r<N ; r++) {
			for(int c = 0; c<M ; c++){
				
				if ( m[r][c] == 0) {
					
					count++;
					
				}
				
			}
	
		}
		
		if (count > maxSafety) {
			maxSafety = count;
		}

		// 지도 탐색 시작
		// 2가 있으면 큐에 넣고 bfs 돌리기
			// 네 방향으로 가면서 (범위 내이고, 0이면 다 갈 수 있)
			// 가는 길 다 2로 바꾸자
			// 
		
		// 끝나고 나서반복문 돌려서 0 탐색하기 : 만나면 count++
		// 다 돌고 maxSafety랑 비교

	}


}
