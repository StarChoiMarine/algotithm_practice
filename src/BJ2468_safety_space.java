import java.util.*;
import java.io.*;



public class BJ2468_safety_space {

	static int S ;
	static int[][] map;
	static int[][] visited;
	static int maxHight;
	static int maxSafety;
	
    static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		S = sc.nextInt();
		
		maxSafety = 0;
		map = new int[S][S];
		visited = new int [S][S];
		maxHight = 0;
		
		
		for(int i =0; i < S; i++) {
			for (int j=0; j< S ; j++) {
				
				map[i][j] = sc.nextInt();
				
				if (maxHight < map[i][j])
					maxHight = map[i][j];
			}
		}
		// 맵에다가 저장하고 최대 높이 저장함
		
		
		// 비의 높이 0 ~ 최대높이까지 늘려가면서 탐색 
		
		for (int h = 0; h <= maxHight; h++) {
			
			boolean [][] visited = new boolean[S][S];
			int count = 0;
			
			for (int r = 0; r < S ; r++ ) {
				
				for(int c =0; c < S ; c++) {
					
					// 비의 높이가 현재 높이보다 작고, 아직 방문하지 않은 곳 -> 탐색 시작
					if( map[r][c] > h && !visited[r][c]) {
						bfs(r,c,h,visited);
						count++;
					}
					
				}
				
			}
			
			if(count > maxSafety) {
				maxSafety = count;
			}
			
		}
		
		System.out.println(maxSafety);

	}
	
	
	// 현재 좌표, 
	public static void bfs(int x, int y, int h, boolean[][] v) {
		
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {x,y});
		
		while(!q.isEmpty()) {
			
			int[] now = new int[2];
			
			now = q.poll();
			
			for (int i =0; i<4;i++) {

				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx >= 0 && nx < S && ny >= 0 && ny < S && map[nx][ny] > h && !v[nx][ny]) {
					
					v[nx][ny] = true;
					q.offer(new int[] {nx,ny});
					
				}
				
			}
	
		}
		
	}

}
