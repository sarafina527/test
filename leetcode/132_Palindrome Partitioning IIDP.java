public class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];//预处理回文判断
        for(int i=0;i<n;i++){//i center 枚举中心
            //odd
            isPalindrome[i][i] = true;
            for(int j=1;i-j>=0&&i+j<n;j++){//向左右延伸标记子串是回文串，直到左右字符不同为止
                if(s.charAt(i-j)==s.charAt(i+j)){
                    isPalindrome[i-j][i+j] = true;
                }else break;                    
            }
            //even
            for(int j=1;i+j<n&&i-j+1>=0;j++){
                if(s.charAt(i-j+1)==s.charAt(i+j))
                    isPalindrome[i-j+1][i+j] = true;
                else break;
            }
        }
        int[] d = new int[n+1];//动态规划求前i个子串的最小回文串的个数
        d[0] = 0;//0 chars 0个字符的边界情况只有0个回文子串
        for(int i=1;i<=n;i++){
            d[i] = Integer.MAX_VALUE;
        }
        for(int i=1;i<=n;i++){
            for(int j=0;j<=i-1;j++){
                if(isPalindrome[j][i-1]){
                    d[i] = Math.min(d[i],d[j]+1);//状态转移
                }
            }
        }
       
        return d[n]-1;
    }
    
}