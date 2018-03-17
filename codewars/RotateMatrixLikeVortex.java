public class RotateMatrixLikeVortex
{
  public static int[][] rotateLikeAVortex(int[][] matrix)
  {
  		int n = matrix.length;
  		int [][] ans = new int[n][n];
  		for(int row=0;row<n;row++){
  			for (int col=0;col<n;col++) {
  				ans[row][col] = matrix[row][col];
  			}
  		}
  		for(int i=0;i<n/2;i++){// i represent the circle from outside to inside
        int times = (i+1)%4;
        while(times>0){
          int tmp = ans[i][i];
          ans[i][i] = ans[i][n-i-1];
          ans[i][n-i-1] = ans[n-i-1][n-i-1];
          ans[n-i-1][n-i-1] = ans[n-i-1][i];
          ans[n-i-1][i] = tmp;
          for(int j=i+1;j<n-i-1;j++){
            tmp = ans[i][j];
            ans[i][j] = ans[j][n-i-1];
            ans[j][n-i-1] = ans[n-i-1][n-j-1];
            ans[n-i-1][n-j-1] = ans[n-j-1][i];
            ans[n-j-1][i] = tmp;
          }

          times--;
        }
  		}
    	return ans;
  }
  public static void main(String[] args) {
  		int [][] matrix = {{5,3,6,1},{5,8,7,4},{1,2,4,3},{3,1,2,2}};
  		int [][] ans = rotateLikeAVortex(matrix);
  		for(int row=0;row<4;row++){
  			for (int col=0;col<4;col++) {
  				System.out.print(ans[row][col]+" ");
  			}
  			System.out.println("");
  		}
  }
}