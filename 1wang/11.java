import java.util.*;
public class Main {  
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);    
        long a = input.nextInt();
        long b = input.nextInt();
        long n = input.nextInt();
        long gcd = a>b?GCD(a,b):GCD(b,a);
        long lbs = a/gcd*b;
        int ans = n/lbs;
        System.out.println(ans);
    }
    public static long GCD(long a,long b){
        if(b==0) return a;
        return GCD(b,a%b);
    }
    
}