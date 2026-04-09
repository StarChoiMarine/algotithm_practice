import java.util.*;
import java.io.*;


public class BJ16236_baby_shark {

	static int N ;
	static int sec ;
	static int map[][];
	static int start[];
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int eatCount = 0;
	static int size = 2;
	
	static List<Fish> foodList = new ArrayList<>();
	
	static public class Fish	{
		
		int dist;
		int r ,c;
		int sec = 0;
		
		public Fish(int dist, int r, int c) {
			
			this.dist =	dist;
			this.r = r;
			this.c = c;
			
		}
		
		@Override
	    public String toString() {
	        return "Fish [r=" + r + ", c=" + c + ", dist=" + dist + "]";
	    }

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0 ; j < N; j++) {
				
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j]== 9) start = new int[] {i,j};
		
			}
	
		}
		
		// 상어가 먹을 수 있는 물고기들 골라서 상자에 담자
		
		while (true) {
		
		foodList.clear();
			
		bfs(start);
		
		if (foodList.isEmpty()) break;
		
		Collections.sort(foodList, (f1,f2) -> {
			
			if (f1.dist != f2.dist) return f1.dist - f2.dist;
			if (f1.r != f2.r) return f1.r - f2.r;
			return f1.c - f2.c;
			
		});
		
		Fish f = foodList.get(0);
		
		map[start[0]][start[1]] = 0;
		
		start[0] = f.r;
		start[1] = f.c;
		
		map[start[0]][start[1]] = 0;
		
		sec += f.dist;

		eatCount++;
		
		if (eatCount == size) {
			
			size++;
			eatCount = 0;
			
		}
		
		}
		
		System.out.println(sec);

	}


	public static void bfs(int[] rc ) {

		int r = rc[0];
		int c = rc[1];
		boolean[][] visited = new boolean[N][N];
		
		
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int [] {r,c,0});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
		
			int curr[] = q.poll();
			
			int x = curr[0];
			int y = curr[1];
			int d = curr[2];

			
			
			
			
			for (int i=0; i<4;i++) { // 크기 고려해서 방향 바꿔가면서 이동하는 로직
				
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
					
					if (map[nx][ny] > size) continue;
					
					else if (map[nx][ny] == size || map[nx][ny] == 0) {
						
						
						q.offer(new int[]{nx,ny,d+1,size});
						visited[nx][ny] = true;
					}
					
					else {
						
						// 물고기 리스트에 넣어두는 로직
						foodList.add(new Fish(d+1,nx,ny));	
						
						q.offer(new int[]{nx,ny,d+1,size});
						visited[nx][ny] = true;
						
					}
					
				}
				
			}

		
		}
		
		
	}
	

	
}
