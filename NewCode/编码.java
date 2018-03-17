import java.util.*;
public class Main { 
    static int[] precnt =  {1,26,651,16276};  
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String code = input.next();
            int n = code.length();
            int ans = 0;
            for(int i=0;i<n;i++){
                int lesscnt = code.charAt(i)-'a';
                int idx = 4-i-1;
                if(i!=0) ans+=1;
                ans+=lesscnt*precnt[idx];
            }
            System.out.println(ans);
        }
    }
       
}