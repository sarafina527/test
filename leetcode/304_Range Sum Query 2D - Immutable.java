public class NumMatrix {
	int m,n;
	int[][] sum;
    public NumMatrix(int[][] matrix) {
    	m = matrix.length;
    	if(m>0){
    		n = matrix[0].length;
    		sum = new int[m][n];
    		for(int i=0;i<m;i++){
    			sum[i][0] = matrix[i][0];
    			for(int j=1;j<n;j++)
    				sum[i][j] = sum[i][j-1]+matrix[i][j];
    		}
    		for(int j=0;j<n;j++){
    			for(int i=1;i<m;i++)
    				sum[i][j] = sum[i-1][j]+sum[i][j];
    		}
    	}
        //System.out.println(Arrays.deepToString(sum));
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int rowa = row1-1,cola=col1-1,rowb=row1-1,colb=col2,rowc=row2,colc=col1-1;
        int a = rowa>=0&&cola>=0?sum[rowa][cola]:0;
        int b = rowb>=0&&colb>=0?sum[rowb][colb]:0;
        int c = rowc>=0&&colc>=0?sum[rowc][colc]:0;
        int d = row2>=0&&row2<m&&col2>=0&&col2<n?sum[row2][col2]:0;
        return d-b-c+a;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */