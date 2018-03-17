import java.util.*;
public class Main { 
    static int len = 32;
    static int[] fib = new int[len];  
    public static void main(String[] args) {
        fib[0] = 0;fib[1] =1;
        for(int i=2;i<len;i++){
            fib[i] = fib[i-2]+fib[i-1];
        }
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int steps = lowBound(n);
            System.out.println(steps);
        }
    }
    public static int lowBound(int target){
        int p = 0,q=len-1;
        while(p<q-1){
            int mid = p+(q-p)/2;
            if(fib[mid]>target){
                q = mid;
            }else
                p = mid;
        }
        int ans = Integer.MAX_VALUE;
        if(p>=0&&p<len)
            ans = Math.abs(target-fib[p]);
        if(q>=0&&q<len){
            if(ans>Math.abs(fib[q]-target))
                ans = Math.abs(fib[q]-target);
        }
        return ans;
    }
       
}