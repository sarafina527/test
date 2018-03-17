public class Solution {
    public int maximalRectangle(char[][] matrix) {
    	int ans = 0;
    	int m = matrix.length;
    	if(m<=0) return 0;
    	int n= matrix[0].length;
        int[][] leftlen = new int[m][n];
        dp(matrix,leftlen);
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(matrix[i][j]=='1'){//枚举每个有效位置
        			int minlen = leftlen[i][j];//存放最小长度
        			for(int h=1;i-h+1>=0;h++){//窮舉矩形高度，往左可延伸的長度，求面积
        				minlen = minlen>leftlen[i-h+1][j]?leftlen[i-h+1][j]:minlen;
        				int area = minlen*h;
        				if(area>ans) ans = area;
        			}
        		}
        	}
        }
        return ans;
    }
    public void dp(char[][] matrix,int[][] leftlen){//切成橫條i,以第j格作為最右端的連續長度
    	for(int i=0;i<matrix.length;i++){
    		for(int j=0;j<matrix[0].length;j++){
    			if(matrix[i][j]=='0')
    				leftlen[i][j] = 0;//init
    			else if(j==0)
    				leftlen[i][j] = 1;//init
    			else
    				leftlen[i][j] = leftlen[i][j-1]+1;//状态转移公式
    		}
    	}
    }
}