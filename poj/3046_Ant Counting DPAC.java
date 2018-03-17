import java.util.*;
public class Main {   
    static int Mod = 1000000; 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int T = input.nextInt();
            int A = input.nextInt();
            int S = input.nextInt();
            int B = input.nextInt();
            Map<Integer,Integer> typecnt = new HashMap<Integer,Integer>();
            for(int i=0;i<A;i++){
                int type = input.nextInt();
                if(typecnt.containsKey(type))
                    typecnt.put(type,typecnt.get(type)+1);
                else
                    typecnt.put(type,1);
            }
            int[][] dp = new int[T+1][B+1];
            dp[0][0] = 1;
            int i=1;
            for(int ty:typecnt.keySet()){
                for(int j=0;j<=B;j++){
                    for(int k=0;k<=j&&k<=typecnt.get(ty);k++){
                        dp[i][j] =(dp[i][j]+dp[i-1][j-k])%Mod;
                    }
                }
                i++;
            }
            int ans = 0;
            for(int j=S;j<=B;j++){
                ans=(ans+dp[T][j])%Mod;
            }
            System.out.println(ans);
        }
    }
       
}