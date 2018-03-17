import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String k = input.next();
            int n = input.nextInt();
            int sofar = 0;
            List<Integer> lens = new ArrayList<Integer>();
            for(int i=0;i<k.length();i++){
                char c = k.charAt(i);
                if(c=='X'){
                    lens.add(k.length()-i);
                }else if(c>='0'&&c<='9'){
                    int yushu = c-'0';
                    yushu = computeMode(yushu,n,k.length()-i);
                    sofar = (sofar+yushu)%n;
                }
            }
            if(lens.size()==0){
                if(sofar==0)
                    System.out.println(1);
                else
                    System.out.println(0);
            }else{
                long[][] dp = new long[lens.size()][n];
                for(int d=0;d<=9;d++){//init
                    int yushu = computeMode(d,n,lens.get(0));
                    dp[0][yushu]++;
                }
                for(int i=1;i<lens.size();i++){
                    for(int d=0;d<=9;d++){
                        int yushu = computeMode(d,n,lens.get(i));
                        for(int j=0;j<n;j++)
                            dp[i][(yushu+j)%n] += dp[i-1][j];
                    }
                }
                System.out.println(dp[lens.size()-1][(n-sofar)%n]);
            }        
        }
    }

    public static int computeMode(int d,int n,int len){
        int ans = d%n;
        for(int i=0;i<len-1;i++){
            ans = (ans*(10%n))%n;
        }
        return ans;
    } 
}