import java.util.*;

public class Solution {

    LinkedList<Integer> stack = new LinkedList<Integer>();
    LinkedList<Integer> helpMin = new LinkedList<Integer>();

    public void push(int node) {
        int min = helpMin.isEmpty()?Integer.MAX_VALUE:helpMin.peek();
        if(node<min) min = node;
        stack.push(node);
        helpMin.push(min);
    }
    
    public void pop() {
        stack.pop();
        helpMin.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return helpMin.peek();
    }
}