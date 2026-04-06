import java.util.*;
import java.io.*;

public class BJ15652_combination {
	
	static int N, M;
	static int [] result;
	
	static StringBuilder sb = new StringBuilder();
	
	
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		result = new int[M];
		
		combination(0,1);
		
		System.out.println(sb);
		
	}

	
	static void combination(int box, int start) {
		
		if(box == M) {
			
			for (int var : result) {
				sb.append(var).append(" ");				
			}
			
			sb.append("\n");
			return;
		}
		
		
		for (int i = start; i <= N ; i++) {
			
			result[box] = i;
			combination(box + 1, i);
			
		}
		
	}
	
}