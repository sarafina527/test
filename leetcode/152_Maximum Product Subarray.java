public class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int startmin,startmax,all = new nums[n-1];
        startmin[n-1] = startmax[n-1] = all[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            if(nums[i]>=0){
                startmin = min(startmin*nums[i],nums[i]);
                startmax = max(startmax*nums[i],nums[i]);
            }else{
                int tmp = startmin;
                startmin = min(startmax*nums[i],nums[i]);
                startmax = max(tmp*nums[i],nums[i]);
            }
            all = max(all,startmax);
        } 
        return all;        
    }
    public int min(int a,int b){
        return a<b?a:b;
    }
    public int max(int a,int b){
        return a>b?a:b;
    }
}
[2,3,-2,4,8,4,-7,5,-8,-9,5,1,7,-3,-8]