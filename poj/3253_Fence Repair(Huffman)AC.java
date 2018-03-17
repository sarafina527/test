import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
            for(int i=0;i<n;i++)
                heap.offer(input.nextInt());
            long ans = 0L;
            while(heap.size()>1){
                int a = heap.poll();
                int b = heap.poll();
                int c = a+b;
                ans+=(long)c;
                heap.offer(c);
            }
            System.out.println(ans);
        }
    }
       
}