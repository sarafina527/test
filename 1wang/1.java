import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int x = input.nextInt();
            int f = input.nextInt();
            int d = input.nextInt();
            int p = input.nextInt();
            int ans = 0;
            while(f>0&&d>0){
                f--;
                d-=x;
                ans++;
            }
            while(d>0){
                d-=(x+p);
                ans++;
            }
            if(d<0) ans--;
            System.out.println(ans);
        }
    }
       
}