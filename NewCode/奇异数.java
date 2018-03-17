import java.util.*;
public class Main {  
    static long[] cnt = new long[11];
    static long[] max = new long[11];
    static long[] min = new long[11];
    static{
       cnt[0] = 1;
       cnt[1] = 9;max[1] = 9;min[1] =1;
       for(int i=2;i<cnt.length;i++){
            cnt[i] = cnt[i-1]*10;
            max[i] = max[i-1]*10+9;
            min[i] = min[i-1]*10;
       }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);    
        long L = input.nextInt();
        long R = input.nextInt();
        int acnt = count(L),bcnt=count(R);
        long ans = 0L;
        if(L/100==R/100){
            for(int i=0;i<=9;i++){
                if(i*10+i>=L%100&&i*10+i<=R%100)
                    ans++;
            }
            System.out.println(ans);
        }else if(acnt==bcnt){
            ans += (R/100-L/100-1)*10;
            for(int i=0; i<=9; ++i) {
                if(i*10+i>=L%100)
                    ans++;
            }
            for(int i=0; i<=9; ++i) {
                if(i*10+i<=R%100)
                    ans++;
            }
            System.out.println(ans);
        }else{
            for(int i=acnt;i<=bcnt;i++){
                if(i==acnt){
                    ans+=(max[i-2]-L/100)*10;
                }else if(i==bcnt)
                    ans+=(R/100-min[bcnt-2])*10;
                else
                    ans+=cnt[i-2]*10;
            }
            for(int i=0;i<=9;i++){
                if(i*10+i>=L%100)
                    ans++;
            }
            for(int i=0;i<=9;i++){
                if(i*10+i<=R%100)
                    ans++;
            }
            System.out.println(ans);
        }
        
    }
    public static int count(long num){
        int ans = 0;
        while(num>0){
            ans++;
            num/=10;
        }
        return ans;
    }
    
}