import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);        
        while(input.hasNext()){
            String s = input.next();
            String t = input.next();
            boolean ans = isSubseq(t,s);
            if(ans)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
    static boolean isSubseq(String t,String s){
        int i=0,j=-1,eqcnt=0;
        for(;i<t.length();i++){
            if(j==s.length())
                return false;
            for(j=j+1;j<s.length();j++){
                if(t.charAt(i)==s.charAt(j)){
                    eqcnt++;
                    break;
                }
            }
        }
        return eqcnt==t.length();
    }
}