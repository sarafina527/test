import java.util.*;
public class Main {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long x = input.nextLong();
        long y = input.nextLong();
        long m = input.nextLong();
        long n = input.nextLong();
        long L = input.nextLong();
        //(x+m*t)%L == (y+n*t)%L => (m-n)*t + L*round = (y-x)
        long[] round = new long[1];
        long[] t = new long[1];
        long a = m-n,c=y-x,b =L;
        if(a<0){
            a=-a;
            c=-c;
        }
        long d = extendEuclid(a,b,t,round);
        System.out.println(d+" "+round[0]+" "+t[0]);
        long cnt = c/d;
        if(cnt*d!=c) System.out.println("Impossible");
        else{
            long ans = t[0]*cnt;
            long mod = b/d;
            if(ans>=0) ans = ans%mod;
            else
                ans = (ans+m)%mod;
            System.out.println(ans);
        }
    }
    public static long extendEuclid(long a,long b,long[] x,long[] y){
        long q,tmp;
        if(b==0){
            x[0] = 1;
            y[0] = 0;
            return a;
        }else{
            q = extendEuclid(b,a%b,x,y);
            tmp = x[0];
            x[0] = y[0];
            y[0] = tmp-(a/b)*y[0];
            return q;
        }
    }
}