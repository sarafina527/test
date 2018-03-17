import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }

    // write your code here
    public static int resolve(String expr) {
       LinkedList<Integer> stack = new LinkedList<Integer>();
       Scanner strin = new Scanner(expr);
       while(strin.hasNext()){
           String c = strin.next();
           
           
            if(c.equals("^")){
               int num = stack.pop();
               stack.push(++num);
            }else if(c.equals("*")){
                int a,b;
                if(stack.isEmpty()==false)
                    a = stack.pop();
                else
                    return -1;
                if(stack.isEmpty()==false)
                    b = stack.pop();
                else 
                    return -1;
                stack.push(a*b);
            }else if(c.equals("+")){
                int a,b;
                if(stack.isEmpty()==false)
                    a = stack.pop();
                else
                    return -1;
                if(stack.isEmpty()==false)
                    b = stack.pop();
                else 
                    return -1;
                stack.push(a+b);
            }else{
                if(stack.size()>=16)
                    return -2;
                stack.push(Integer.parseInt(c));
            }
        }
       if(stack.isEmpty()==false)
           return stack.pop();
       else return -1;
    }
}