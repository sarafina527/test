import java.util.*;
public class Solution {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(matrix.length==0||matrix[0].length==0) return ans;
        int m = matrix.length,n = matrix[0].length;
        int mid = (Math.min(m,n)+1)/2;
        for(int k=0;k<mid;k++){
            int i,j;
            for(j=k;j<n-k;j++)
                ans.add(matrix[k][j]);
            for(i=k+1;i<m-k;i++)
                ans.add(matrix[i][n-k-1]);
            if(m-k-1>k){
                for(j=n-k-2;j>=k;j--)
                    ans.add(matrix[m-k-1][j]);
            }
            if(n-k-1>k){
                for(i=m-k-2;i>k;i--)
                    ans.add(matrix[i][k]);
            }
       }
       return ans;
    }
}