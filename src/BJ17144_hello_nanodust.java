import java.util.*;
import java.io.*;

public class BJ17144_hello_nanodust {

	
	static int R, C, T;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int m1, m2;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		int sum = 0;
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		
		for(int i =0; i< R ; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			for (int j =0;j< C; j++) {

				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
			
			if (map[i][0]==-1) {
				
				m2 = i;
				
			}
			
		}
		
		m1 = m2 -1;	// 공기청정기 위치
		
		
		while(true) {
			
			if (T == 0) break;
			
			dust();
			
			
			cleaner();

			
			T--;
			
		}
		

	
		
		for(int i =0; i< R ; i++) {
			for (int j =0; j< C; j++) {

				sum += map[i][j];

			}
		}
		
		System.out.println(sum + 2);
		
	}
	
	
	// 미세먼지 확산은 동시에 일어난다 : 서로 영향을 주면 안된다 ->더해야 할 값을 카피본에 저장을 해서 끝에 한번에 더해주자
	public static void dust() {
		
		int add[][] = new int[R][C];
		
		
		// 배열을 모두 순회하면서 
		for(int r =0; r< R ; r++) {
			for (int c =0; c< C; c++) {
				
				// 0이 아닐시 먼지 확산
				if (map[r][c] !=0 && map[r][c]!= -1) {
					
					int sp = map[r][c]/5 ;
					int count = 0;
					
					for(int i =0; i<4;i++) {
						
						int nx = r + dx[i];
						int ny = c + dy[i];

						
						if (nx>=0 && ny>=0 && nx<R && ny< C && map[nx][ny]!= -1) {
							
							add[nx][ny] += sp;
							count++;
							
						}
					
					}
					
					map[r][c] = map[r][c] - sp*count;

				}
				

			}
		}
		
		for(int r =0; r< R ; r++) {
			for (int c =0; c< C; c++) {
				
				map[r][c] += add[r][c];
				
			}
			
		}

		
	} 
	
	
	
	public static void cleaner() {
		
		// 공기청정기 안으로 들어오는 라인
		
		for (int i = m1-1; i > 0; i--) {
			
			map[i][0] = map[i-1][0];
		}
		
		// 돌아서 공기 청정기 쪽으로
		
		for (int i = 0; i < C - 1; i++) {
			
			map[0][i] = map[0][i+1];
			
		}
		
		// 나와서 처음 꺾이는 쪽
		
		for (int i = 0; i < m1; i++) {
			
			map[i][C-1] = map[i+1][C-1];
			
		}
		
		// 나오는 쪽
		for (int i =C-1; i>1; i--) {
			
			map[m1][i] = map[m1][i-1];

			
		}
		
		//-------------------------------------
		
		// 공기청정기 안으로 들어오는 라인
		
		for (int i = m2 + 1; i < R-1; i++) {
					
			map[i][0] = map[i+1][0];
			
		}
		
		for (int i = 0; i < C -1 ; i++) {
			
			map[R-1][i] = map[R-1][i+1];
			
		}
		
		for (int i = R - 1; i > m2; i--) {
			
			map[i][C-1] = map[i-1][C-1];
		}
		
		for (int i =C-1; i>1; i--) {
			
			map[m2][i] = map[m2][i-1];
			
		}
		
		
		map[m1][1] = 0;
		map[m2][1] = 0;
		
		
		
		
		
	}
	
	
	
	
	
	

}
