import java.util.*;
import java.io.*;


public class BJ3190_snake {

	
	
	static int N, K, L;
	static int sec;

	static int[][] map;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	
	static class Move {
		
		int time;
		char dir;
		
		public Move (int time, char dir) {
			
			this.time = time;
			this.dir = dir;
			
		}
		
	}
	
	static Deque<int[]> snake = new LinkedList<>(); 
	static Queue<Move> moveQueue = new LinkedList<>();
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for (int i =0; i< N; i++) {
			
			for(int j =0; j< N;j++) {
				
				map[i][j] = 0;

			}
		}
		
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		
		

		
		for (int i = 0; i <K; i++ ) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			
			map[r][c] = 1;
	
		}
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		
		for (int i = 0 ; i < L; i++) {
			
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			moveQueue.offer(new Move(t,d));
			
		}
	
		map[0][0] = 2;
		snake.addFirst(new int[] {0,0});
		
		int ndx = 0;
		int ndy = 0;
		int dir = 0;
		
		
		// 다 입력 받았음

		// 뱀이 이동하는 로직 
		while(true) {

			sec++;

			
			int [] now = snake.peekFirst();
			
			int nx = now[0] + dx[dir];
			int ny = now[1] + dy[dir];
			
			// 내 몸에 부딪힐 경우

			if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;
			
			if (map[nx][ny] == 2) break;
			
			
			boolean isApple = (map[nx][ny] == 1);
			
			
			snake.addFirst(new int[] {nx,ny});
			
			map[nx][ny] = 2;
			if (!isApple) {
			int[] tail = snake.removeLast(); 
	        map[tail[0]][tail[1]] = 0; 
			}
			
			
			// 방향을 트는 로직 
			if (!moveQueue.isEmpty()) {
				
				Move nextMove = moveQueue.peek();
				
				if(sec == nextMove.time) {
					
					moveQueue.poll();
					
					if(nextMove.dir == 'D') {
						
						dir = (dir+1) % 4;
		
					} else {
						
						dir = (dir+3) % 4;
					}
					
				}
			}
			
			
			
			
			
			
		}
		
		
		System.out.println(sec);
		
	}

}
