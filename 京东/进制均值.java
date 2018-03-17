import java.util.*;
public class Main {
    static int[] digit= new int[16];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int x = input.nextInt();
            Arrays.fill(digit,0);
            if(x==1||x==2)
                System.out.println(1);
            else{
                int ans = 0;
                for(int m=x-1;m>=2;m--){//jinzhi
                    ans+=convertToM(x,m,digit);                    
                }
                int gcd = gcd(ans,x-2);
                System.out.println(ans/gcd+"/"+(x-2)/gcd);
            }
        }
    } 
    public static int convertToM(int x,int m,int[] digit){
        int ans = 0;
        for(int i=0;x>0;i++){
            digit[i] = x%m;
            x/=m;
            ans+=digit[i];
        }
        return ans;
    }
    public static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}