import java.util.*;
import java.math.*;
public class Main {  
    static BigInteger Mod = new BigInteger("1000000007");  
    static int max = 100000;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);    
        while(input.hasNext()){
            String x = input.next();
            int maxL = 3*max;
            BigInteger cur = new BigInteger(x);
            cur = cur.shiftLeft(1).add(BigInteger.ONE);
            int i = 2;
            for(;i<=maxL;i++){
                cur = cur.shiftLeft(1).add(BigInteger.ONE);
                if(cur.mod(Mod).equals(BigInteger.ZERO))
                    break;
            }
            if(i>=maxL)
                System.out.println(-1);
            else{
                if(i%3==0)
                    System.out.println(i/3);
                else
                    System.out.println(i/3+1);               
            }
        }
    }    
}