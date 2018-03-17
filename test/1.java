import java.util.*;
public class Main {  
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);    
        String str = input.next();
        int ans = str.length();
        for(int s=0;s<n;i++){
            int tmp = 0;
            for(int i=0;i<=s;i++){
                if(str.charAt(i)!='R')
                    tmp++;
            }
            for(int i=s+1;i<str.length;i++){
                if(str.charAt(i)!='G')
                    tmp++;
            }
            if(tmp<ans)
                ans = tmp;
        }
        System.out.println(ans);
    }
    
}