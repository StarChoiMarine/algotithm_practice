import java.util.*;
import java.io.*;


public class CodeTree_temple_search {

    static int K, M;
    static int[][] map;
    static int[] newnum;
    static int N = 5;
    static int Mpoint = 0;
    
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    


    public static void main(String[] args) throws IOException{
    	
        // Please write your code here.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        

        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[5][5];
        
        newnum = new int [M];
        

        for(int i = 0; i <N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j =0; j<N; j++){

                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i <M; i++) {
        	
        	newnum[i] = Integer.parseInt(st.nextToken());
        	
        }
        
     for (int turn = 0; turn < K; turn++) {
        
        int MaxCount = 0, bestAngle = -1, bestR = -1, bestC = -1;
        
        
        for (int angle = 90; angle < 271; angle += 90) {
        	for (int  j = 1; j < 4; j++) {
        		for (int i  = 1; i < 4; i++) {
	            	
	            	int[][] copy = copy(map);
	            	
	            	rotate(angle, copy, i, j);
	            	int score = search(copy);        		
	            	
	            	if (score > MaxCount) {
	            		
	            		MaxCount = score;
	            		
	            		bestAngle = angle;
	            		bestC = i;
	            		bestR = j;
	            	}
	            	
	            	
	            	
	            }
        	}
        }
        
        
        
        if (MaxCount == 0) break;
        
        rotate(bestAngle,map,bestC,bestR);
        
        
        int turnScore = 0;
        
        while (true) {
        
	        int score = mainSearch(map);
	        if (score==0 ) break;
	        turnScore += score;

        }
        
       sb.append(turnScore).append(" ");
      
     }
     
     
     System.out.print(sb);
     
     
     
    }
    
    
    static int[][] copy(int[][] a) {
    	
    	int [][] clone = new int[5][5];
    	
    	for (int i=0; i<5;i++) {
    		
    		for(int j = 0 ; j<5 ; j++){
    			
    			clone[i][j] = a[i][j];
    			
    		}
    		
    	}
    
    return clone;
    	
    }
    
    
    static void rotate(int a, int[][] m, int r, int c) {

        int[][] temp = new int[3][3];
        
      
        int sx = r - 1;
        int sy = c - 1;
        
     
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                
                if (a == 90) {
    
                    temp[j][2 - i] = m[sx + i][sy + j];
                } 
                else if (a == 180) {
                  
                    temp[2 - i][2 - j] = m[sx + i][sy + j];
                } 
                else if (a == 270) {
                    
                    temp[2 - j][i] = m[sx + i][sy + j];
                }
                
            }
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m[sx + i][sy + j] = temp[i][j];
            }
        }
    }
    
    static int search(int[][] m) {

    	int size =0;
    	boolean[][] visited = new boolean[5][5];
    	
    	Queue<int[]> q = new LinkedList<>();
    	
    	
    	
    	for(int i =0; i<5;i++) {
    		
    		for(int j =0; j<5;j++) {
    		
    			if (visited[i][j]) continue;
    			int count = 0;
    			
    			q.offer(new int[] {i,j,1});
    			visited[i][j] = true;
    			
    			while(!q.isEmpty()) {

	    			int[] curr = q.poll();
    				
	    			count++;
	    			
	    			int x = curr[0];
    				int y = curr[1];
    				int s = curr[2];
    				
	    			int num = m[i][j];
	    			
	    			
	    			for (int a =0; a<4;a++) {
	    				
	    			int nx = x + dx[a];
	    			int ny = y + dy[a];
	    			
		    			if (nx >= 0 && ny >= 0 && nx<5 && ny<5 && !visited[nx][ny] && m[nx][ny] == num) {
		    				
		    				q.offer(new int[] {nx,ny,s+1});
		    				visited[nx][ny] = true;
		    			}
		    			
	    			}
	    			
	    		}
    			
    			
    			if (count >= 3) size += count;
    			
	    		
	    	}
    	
    	}
    	
    	return size;
    }


    static int mainSearch(int[][] m) {

    	boolean[][] visited = new boolean[5][5];
    	
    	List<int[]> RemoveList = new ArrayList<>();
    	Queue<int[]> q = new LinkedList<>();
    	
    	
    	
    	for(int i =0; i<5;i++) {
    		for(int j =0; j<5;j++) {
    		
    			List<int[]> cart = new ArrayList<>();
    			
    			
    			if (visited[i][j]) continue;
    			
    			q.offer(new int[] {i,j});
    			cart.add(new int [] {i,j});
    			
    			visited[i][j] = true;
    			
    			while(!q.isEmpty()) {

	    			int[] curr = q.poll();
    				int x = curr[0];
    				int y = curr[1];
    				
    				
	    			int num = m[i][j];
	    			
	    			for (int a =0; a<4;a++) {
	    				
	    			int nx = x + dx[a];
	    			int ny = y + dy[a];
	    			
	    			
		    			if (nx >= 0 && ny >= 0 && nx<5 && ny<5 && !visited[nx][ny] && m[nx][ny] == num) {
		    				q.offer(new int[] {nx,ny});
		    				visited[nx][ny] = true;
		    				cart.add(new int [] {nx,ny});
		    				
		    			}
		    			
	    			}
	    			
	    		}
    			
    			if (cart.size() >= 3) {
    				
    				RemoveList.addAll(cart);
    				
    			}
    			
	    		
	    	}
    	
    	}// 돌면서 제거해야할 리스트 확보 완료
    	
    	
    	if (RemoveList.isEmpty()) return 0;
    	
    	
    	Collections.sort(RemoveList, (a, b)-> {
    		
    		if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
    		return Integer.compare(b[0],a[0]);
    		
    	});
    	
    	
    	for (int i =0; i < RemoveList.size(); i++) {
    		
    		int curr[] = RemoveList.get(i);
    		m[curr[0]][curr[1]] = newnum[Mpoint+i];
    	}
    	
    	Mpoint += RemoveList.size();
    	
    	return RemoveList.size();
    	

    }

    
    
}