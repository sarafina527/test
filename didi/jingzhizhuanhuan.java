import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int m = input.nextInt();
            int n = input.nextInt();
            String ans = trans(m,n);
            System.out.println(ans);
        }
    }
    public static String trans(int m,int n){
        StringBuilder sb = new StringBuilder();
        int mm = m;
        if(m==0) return "0";
        if(m<0){
            mm = -m;
        }
        while(mm>0){
            char mod = (char)(mm%n);
            if(mod>9) mod = (char)(mod-10+'A');
            else mod = (char)(mod+'0');
            sb.append(mod);
            mm/=n;
        }
        if(m<0) sb.append('-');
        return sb.reverse().toString();
    }
       
}