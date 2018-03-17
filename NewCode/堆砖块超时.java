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
            int[] ans = new int[1];
            ans[0] = -1;
            backtrack(0,0,0,h,ans);
            System.out.println(ans[0]);            
        }
    }
    public static void backtrack(int left,int right,int i,int[] h,int[] ans){
        if(left==right&&left>0&&left>ans[0]) ans[0] = left;
        if(i==h.length) return;
        backtrack(left+h[i],right,i+1,h,ans);
        backtrack(left,right,i+1,h,ans);
        backtrack(left,right+h[i],i+1,h,ans); 
    }    
}