import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<Integer>();
        while(input.hasNext()){
            nums.add(input.nextInt());
        }
        int n = nums.size();
        int k = nums.get(n-1);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int i=0;
        for(;i<n-1&&i<k;i++){
            pq.offer(nums.get(i));
        }
        for(;i<n-1;i++){
            if(nums.get(i)>pq.peek()){
                pq.poll();
                pq.offer(nums.get(i));
            }
        }
        System.out.println(pq.peek());
    }
       
}