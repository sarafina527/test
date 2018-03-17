import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Integer> nums = new LinkedList<Integer>();
        while(input.hasNext()){
            nums.add(input.nextInt());
        }
        int n = nums.size();

        int dp[] = new int[n];  
        Iterator<Integer> it = nums.iterator();          
        dp[0] = it.next();
        int ans = dp[0];        
        for(int i=1;i<n&&it.hasNext();i++){
            int cur = it.next();
            dp[i] = cur;
            dp[i] = Math.max(dp[i-1]+cur,dp[i]);
            ans = Math.max(dp[i],ans);
        }
        System.out.println(ans);
    }
       
}