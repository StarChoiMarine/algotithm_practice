import java.util.*;
import java.io.*;


public class BJ14888_inserting_calcuater {

	
	static int N;
	static int[] num_set;
	static int[] calc;
	static int max;
	static int min;
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		num_set = new int[N];
		
		for (int i = 0; i < N; i++) {
			num_set[i] = sc.nextInt();
		}
		
		calc = new int[4]; // (0) + (1) - (2) * (3)/
		
		for (int i = 0; i < 4; i++) {
			calc[i] = sc.nextInt();
		}
		
		
		max = -1000000000;
		min = 1000000000;
		
		
		dfs(num_set[0],1);
		
		System.out.println(max);
		System.out.println(min);
		
	}
	
	public static void dfs(int sum, int i) {
		
		
		if (i == N) {
			
			if (max < sum)
				max = sum;
			if (min > sum)
				min = sum;
			return;
		}
		
			if (calc[0] != 0) {
				
				calc[0]--;
				dfs(sum + num_set[i],i+1);
				
				calc[0]++;
			}
			
			
			if (calc[1] != 0) {
				
				
				calc[1]--;
				dfs(sum - num_set[i],i+1);
				
				calc[1]++;
				
			}

			if (calc[2] != 0) {
				
				
				calc[2]--;
				dfs(sum * num_set[i],i+1);
				
				calc[2]++;
				
			}
			
			if (calc[3] != 0) {
				
				
				calc[3]--;
				dfs(sum / num_set[i],i+1);
				
				calc[3]++;

			}


	
	}
	
	
}