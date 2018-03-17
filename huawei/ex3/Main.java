import java.util.*;

public class Main{

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while(input.hasNext()){
			int m = input.nextInt();
			int n = input.nextInt();
			int[][] board = new int[m][n]; 

			for(int i=0;i<m;i++){
				board[i] = new int[n];
				for(int j=0;j<n;j++){
					board[i][j] = nextInt();
				}
			}
			System.out.println(help(board,m-1,n-1));			
			
		}
		
        
        		
	}
	public int help(int[][] arr, int i, int j){
	
		if(i==-1||j==-1) return 0;
		else if(i==0 && j==0) return arr[i][j]; 
		else return Math.max(help(arr,i-1,j)+arr[i][j], help(arr,i,j-1)+arr[i][j]);
	}
}