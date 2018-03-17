import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String x = input.next();
            String y = input.next();
            int sum = Integer.parseInt(rev(x))+Integer.parseInt(rev(y));
            String ans = rev(String.valueOf(sum));
            System.out.println(ans);
        }
    }
    public static String rev(String str){
        boolean leadzero = true;
        StringBuilder sb = new StringBuilder();
        for(int i=str.length()-1;i>=0;i--){
            char c = str.charAt(i);
            if(c=='0'&&leadzero)
                continue;
            else{
                leadzero = false;
                sb.append(c);
            }
        }
        return sb.toString();
    }
}