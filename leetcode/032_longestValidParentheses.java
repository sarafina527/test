public class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int ans = 0;
        if(n==0) return ans;
        int[] rightlen = new int[n];
        int[] leftlen = new int[n];
        boolean flag = true;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)=='('&&s.charAt(i+1)==')'){
                rightlen[i] = 2;
                leftlen[i+1] = 2;
                if(ans<2) ans = 2;
            } 
        }
        while(flag){
            for(int i=0;i<n-1;){//合并所有相切的括号
                if(rightlen[i]!=0){
                    if(i+rightlen[i]<n-1&&rightlen[i+rightlen[i]]!=0){//可以合并，并列的两组括号
                        rightlen[i] = rightlen[i]+rightlen[i+rightlen[i]];
                        if(rightlen[i]>ans) ans = rightlen[i];
                    }else{
                        i += rightlen[i];
                    }
                }else i++;
            }
            flag = false;
            for(int i=0;i<n-1;){//可能发生嵌套
                if(rightlen[i]!=0){
                    int cur = i;
                    while(i-1>=0&&i+rightlen[i]<n&&s.charAt(i-1)=='('&&s.charAt(i+rightlen[i])==')'){
                        rightlen[i-1] = rightlen[i]+2;
                        i--;                    
                    }
                    if(cur!=i){
                        flag = true;
                        if(rightlen[i]>ans) ans = rightlen[i];
                    }
                    i+=rightlen[i];
                }else i++;
            }
        }

        return ans;
    }
}