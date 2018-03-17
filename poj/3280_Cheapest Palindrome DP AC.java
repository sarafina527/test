import java.util.*;
public class Main {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        String id = input.next();
        Map<Character,Integer> acost = new HashMap<Character,Integer>();
        Map<Character,Integer> dcost = new HashMap<Character,Integer>();
        for(int i=0;i<n;i++){
            char c = input.next().charAt(0);
            int ac = input.nextInt();
            int dc = input.nextInt();
            acost.put(c,ac);
            dcost.put(c,dc);
        }
        int len = id.length();
        int[][] dp = new int[len][len+1];
        for(int j=2;j<=len;j++){
            for(int i=len-j;i>=0;i--){
                char s=id.charAt(i),e=id.charAt(i+j-1);
                if(s==e)
                    dp[i][j] = dp[i+1][j-2];
                else{
                    dp[i][j] = Integer.MAX_VALUE;
                    if(dcost.containsKey(s))
                        dp[i][j] = Math.min(dp[i+1][j-1]+dcost.get(s),dp[i][j]);
                    if(dcost.containsKey(e))
                        dp[i][j] = Math.min(dp[i][j-1]+dcost.get(e),dp[i][j]);
                    if(acost.containsKey(e))
                        dp[i][j] = Math.min(dp[i][j-1]+acost.get(e),dp[i][j]);
                    if(acost.containsKey(s))
                        dp[i][j] = Math.min(dp[i+1][j-1]+acost.get(s),dp[i][j]);
                }
            }
        }
        System.out.println(dp[0][len]);
    }
}