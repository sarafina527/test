import java.util.*;

public class Main{
    static int n = 100000;
    public static void main(String[] args) {
        int[] lucn = new int[n+1];
        for(int i=1;i<=n;i++){
            if(countOne(i)==TenSum(i))
                lucn[i] = lucn[i-1]+1;
            else
                lucn[i] = lucn[i-1];
        }
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
           int m = input.nextInt();
           
            System.out.println(lucn[m]);
        }
    }
    public static int countOne(int n){
        int ans = 0;
        while(n>0){
            ans++;
            n = n&(n-1);
        }
        return ans;
    }
    public static int TenSum(int n){
        int ans = 0;
        while(n>0){
            ans+= n%10;
            n/=10;
        }
        return ans;
    }
    
}