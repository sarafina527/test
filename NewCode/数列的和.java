import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int m = input.nextInt();
            double ans =0;
            double cur = n;
            for(int i=0;i<m;i++){
                ans+=cur;
                cur=Math.sqrt(cur);
            }
            System.out.format("%.2f",ans);
        }
    }
       
}