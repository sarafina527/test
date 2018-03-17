public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length,ans=0;
        Map<Integer,Integer> cnt = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
            	int t = C[i]+D[j];
            	if(cnt.containsKey(t))
            		cnt.put(t,cnt.get(t)+1);
            	else
            		cnt.put(t,1);
            }
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                int ab = A[i]+B[j];
                if(cnt.containsKey(-ab))
                	ans+=cnt.get(-ab);
            }
        return ans;
    }
}