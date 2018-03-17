import java.util.*;
public class Main { 
    static int INF = 1000001;   
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int[] a = new int[n];
            //int[] dp = new int[n][2];
            for(int i=0;i<n;i++){
                a[i] = input.nextInt();
            }
            int max = 1<<n;
            int ans = Integer.MAX_VALUE;
            for(int i=0;i<max;i++){
                ans = Math.min(ans,count(a,i));
            }
            //int ans = Math.min(dp[n-1][0],dp[n-1][1]);            
            System.out.println(ans);
        }
    }
    public static int count(int[] a,int bit){
        int last0 = -1,last1 = -1,ans=0;
        for(int i=0;i<a.length;i++){
            if((bit&(1<<i))>0){
                if(last1!=-1){
                    ans+=Math.abs(last1-a[i]);
                    last1 = a[i];
                }else{
                    last1 = a[i];
                }
            }else{
                if(last0!=-1){
                    ans+=Math.abs(last0-a[i]);
                    last0 = a[i];
                }else{
                    last0 = a[i];
                }
            }
        }
        return ans;
    }
       
}