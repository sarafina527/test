import java.util.*;
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> que = new LinkedList<Integer>();
        if(n<=0||m<=0) return -1;
        for(int i=0;i<n;i++){
            que.offer(i);
        }
        while(que.size()>1){
            for(int i=0;i<m-1;i++){
                que.offer(que.poll());
            }
            que.poll();
        }
        return que.poll();
    }
}