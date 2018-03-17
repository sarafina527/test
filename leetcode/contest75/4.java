class Solution {
    public int bestRotation(int[] A) {
        int ans = -1,N=A.length,s = 0;
        for(int k=0;k<N;k++){
            int cnt = 0;
            for(int i=0;i<=k-1;i++){
                if(N+i-A[i]>=k)
                    cnt++;
            }
            for(int i=k;i<N;i++){
                if(i-A[i]>=k)
                    cnt++;
            }
            if(cnt>s){
                ans = k;
                s = cnt;
            }
        }
        return ans;
    }
}
