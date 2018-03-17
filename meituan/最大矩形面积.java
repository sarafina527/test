import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int[] h = new int[n];
            for(int i=0;i<n;i++){
                h[i] = input.nextInt();
            }
            int[] left = new int[n];
            int[] right = new int[n];
            LinkedList<Integer> stk = new LinkedList<Integer>();
            for(int i=0;i<n;i++){
                while(!stk.isEmpty()&&h[stk.peek()]>=h[i]){
                    stk.pop();
                }
                left[i] = stk.isEmpty()?0:stk.peek()+1;
                stk.push(i);
            }
            stk.clear();
            for(int i=n-1;i>=0;i--){
                while(!stk.isEmpty()&&h[stk.peek()]>=h[i])
                    stk.pop();
                right[i]= stk.isEmpty()?n:stk.peek();
                stk.push(i);
            }
            int ans = 0;
            for(int i=0;i<n;i++){
                int tmp = (right[i]-left[i])*h[i];
                if(tmp>ans) ans = tmp;
            }
            System.out.println(ans);
        }
    } 
}