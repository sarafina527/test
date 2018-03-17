import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String exp = input.next();
            Set<Character> ops = new HashSet<Character>();
            ops.add('+');ops.add('-');ops.add('*');
            int i=0,j=i+1;
            for(j=i+1;j<exp.length()&&!ops.contains(exp.charAt(j));j++);
            int ans = Integer.valueOf(exp.substring(i,j));
            if(j==exp.length()) System.out.println(ans);
            else{
                char opt=exp.charAt(j);
                int opi = j;
                for(j=j+1;j<=exp.length();j++){
                    if(j==exp.length()||ops.contains(exp.charAt(j))){
                        int b = Integer.valueOf(exp.substring(opi+1,j));
                        ans = comput(ans,b,opt);
                        if(j<exp.length()){
                            opt = exp.charAt(j);
                            opi = j;
                        }
                    }
                }
                System.out.println(ans);
            }          
            
        }
    }
    public static int comput(int a,int b,char op){
        if(op=='+')
            return a+b;
        else if(op=='-') return a-b;
        else return a*b;
    }
}