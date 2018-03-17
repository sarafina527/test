import java.util.*;
public class Main {    
    static int Mod = 1000000007;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int ans = 0;
            for(int a=1;a<=n;a++){
                for(int b=1;b<=n;b++)
                    for(int c=1;c<=n;c++)
                        for(int d=1;d<=n;d++)
                            if(Math.pow(a,b)==Math.pow(c,d)){
                                ans++;
                                //System.out.println(a+" "+b+" "+c+" "+d);
                            }
                                
            }
            System.out.println(ans);
        }
    } 
}