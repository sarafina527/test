import java.util.*;
public class Main {
    static class interval{
        int s;int e;int milk;
        public interval(int ss,int ee,int mm){
            s = ss;e=ee;milk=mm;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int r = input.nextInt();
        interval[] ins = new interval[m];
        for(int i=0;i<m;i++){
            int s = input.nextInt();
            int e = input.nextInt();
            int milk = input.nextInt();
            ins[i] = new interval(s,e,milk);
        }
        Arrays.sort(ins,new Comparator<interval>(){
            public int compare(interval i1,interval i2){
                return i1.s-i2.s;
            }
        });
        int[] dp = new int[m];
        for(int i=0;i<m;i++){
            dp[i] = ins[i].milk;
            // int j;  why????? not
            // for(j=i-1;j>=0&&ins[j].e+r>=ins[i].s;j--);
            // for(int k=j;j>=0&&k>=0&&ins[k].e+r>=ins[j].s;k--){
            //     dp[i] = Math.max(dp[k]+ins[i].milk,dp[i]);
            // }
            for(int j=0;j<i;j++){
                if(ins[j].e+r<=ins[i].s)
                    dp[i] = Math.max(dp[j]+ins[i].milk,dp[i]);

            }
        }
        int ans = 0;
        for(int i=0;i<m;i++)
            if(ans<dp[i]) ans=dp[i];
        System.out.println(ans);
    }
}