import java.util.*;

public class MaxInnerRec {
    public int countArea(int[] A, int n) {
        int ans=0;
        int[] L = new int[n];
        int[] R = new int[n];
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&A[stack.peek()]>=A[i]){
                stack.pop();
            }
            L[i] = stack.isEmpty()?0:stack.peek()+1;
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&A[stack.peek()]>=A[i])
                stack.pop();
            R[i] = stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        for(int i=0;i<n;i++){
            int area = (R[i]-L[i])*A[i];
            if(area>ans) ans = area;
        }
        return ans;
    }
}