import java.util.*;

public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String str = input.next();
            int ans = count(str);
            System.out.println(ans);            
        }
    } 
    public static int count(String str){
        int ans = 1;
        LinkedList<Character> stk = new LinkedList<Character>();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='('){
                tmp++;
                ans*=tmp;
                stk.push('(');
            }else{
                tmp=0;
                stk.pop();
            }
            if(stk.size()==0){
                int tmp = 0;
                for(int j=i;j>=0&&str.charAt(j)==')';j--){
                    tmp++;
                }
                ans = tmp*count(str.substring(1,i-1))*count(str.substring(i+1));
            }
        }
        return ans;
    }
}