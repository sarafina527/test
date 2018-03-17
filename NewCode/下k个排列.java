import java.util.*;
public class Main {  
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int k = input.nextInt();
            int[] nums = new int[n];
            for(int i=0;i<n;i++){
                nums[i] = input.nextInt();
            }
            while(k-->0){
                next_perm(nums);
            }
            for(int i=0;i<n-1;i++)
                System.out.print(nums[i]+" ");
            System.out.println(nums[n-1]);
        }  
    }
    public static void next_perm(int[] nums){
        int n = nums.length,i=n-1;
        for(;i>0;i--){
            if(nums[i-1]<nums[i])
                break;
        }
        if(i==0) reverse(nums,0,n-1);
        else{
            int t = nums[i-1],j=n-1;
            for(;j>=i;j--){
                if(nums[j]>t)
                    break;
            }
            nums[i-1] = nums[j];
            nums[j] = t;
            reverse(nums,i,n-1);
        }
    }
    public static void reverse(int[] nums,int s,int e){
        while(s<e){
            int t = nums[s];
            nums[s++] = nums[e];
            nums[e--] = t;
        }
    }
   
}