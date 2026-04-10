import java.util.*;
import java.io.*;


public class BJ14890_upway {

	
	
	static int  N, L;
	static int[][] map;
	static int row = 0;

	static boolean[] visited;
	
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		

		map = new int[N][N];		
		
		for (int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0 ; j< N ; j++) {
				
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
			
		}
		
		for (int r=0 ; r < N; r++) {
			
			visited = new boolean[N];
			row_check(r);
			
		}

		for (int i = 0; i< N;i++) {
			
			for(int j = i + 1 ;j < N ; j++) {
				
				int temp = map[i][j];
				map[i][j]= map[j][i];
				map[j][i]= temp;
			}		
		}
		
		
		for (int r=0 ; r < N; r++) {
			
			visited = new boolean[N];
			row_check(r);
			
		}
		
		
		System.out.println(row);
		
		
	}

	
	public static void row_check(int r) {
		
		
		for( int c = 0; c < N -1 ; c++) {
			
			int now = map[r][c];
			int next = map[r][c+1];
			
			if (now == next) continue;
			
			else if(next - now == 1) {
				
				if((c+1) >= L) {
					
					for (int i =0; i<L;i++) {
						
						if(map[r][c-i] != map[r][c] || visited[c-i]) return;	
						
						else visited[c-i] = true;
					}
					
					
				} else return;
				
				
				
			}
			else if(next - now == -1) {
				
				if(c+L < N) { //범위 체크
					
					for (int i =0; i<L;i++) { // 길이체크 시작할건데 
						
						if(map[r][c+i+1] != map[r][c+1] || visited[c+1+i]) return; // 다음칸들이 다르면
					
						else {
							visited[c+i+1] = true;
							
						}
						
					}
					
					c += (L-1);
					
					
				} else return;

				
			}
			
			else return; // 높이가 2이상 차이날 때

		}
		
			
		row++;
	}
	
	
	
}
