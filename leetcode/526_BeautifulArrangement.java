public class Solution {
    public int countArrangement(int N) {
        int[] ans = new int[1];
        ans[0] = 0;
        boolean[] used = new boolean[N+1];
        backtracking(1,used,ans);
        return ans[0];
    }
    public void backtracking(int cur,boolean[] used,int[] ans){
        int n = used.length-1;
        if(cur==n+1)
            ans[0]++;
        else{
            for(int cand=1;cand<=n;cand++){//枚举所有可能
                if(!used[cand]){//筛选合法
                    used[cand] = true;
                    if(cand%cur==0||cur%cand==0){//condition筛选合法，满足约束的选项
                        backtracking(cur+1,used,ans);//递归调用
                    }
                    used[cand] = false;   //恢复辅助变量              
                }
            }
        }
    }
}