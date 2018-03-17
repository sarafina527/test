import java.util.*;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int i=0,j=0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for(;j<popA.length;j++) {
            while(stack.isEmpty()||stack.peek()!=popA[j])
                if(i<pushA.length)
                    stack.push(pushA[i++]);
                else return false;
            if(!stack.isEmpty()&&stack.peek()==popA[j]){
                stack.pop();
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;       
    }
}