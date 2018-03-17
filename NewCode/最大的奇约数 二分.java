import java.util.*;
import java.math.BigInteger;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int mid = n/2;
        int high = n;
        int cnt = 1;
        BigInteger ans = BigInteger.valueOf(0);
        while(mid>0){
            int i= (mid+1)/2,j= (high-1)/2,c=(j-i+1);
            BigInteger sum = BigInteger.valueOf(c);
            sum = sum.multiply(BigInteger.valueOf(2*i+1));
            sum = sum.add(BigInteger.valueOf(c-1).multiply(BigInteger.valueOf(c)));
            //int sum = c*(2*i+1)+(c-1)*c; 
            ans = ans.add(sum.multiply(BigInteger.valueOf(cnt)));
            high = mid;
            mid = high/2;
            cnt++;
        }
        ans = ans.add(BigInteger.valueOf(1*cnt));
        System.out.println(ans);
    }
}
