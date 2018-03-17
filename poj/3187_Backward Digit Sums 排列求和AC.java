import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int sum = input.nextInt();
            int[] ans = new int[n];
            Set<Integer> visited = new HashSet<Integer>();
            backtrack(ans,0,visited,n,sum);
            for(int i=0;i<n-1;i++)
                System.out.print(ans[i]+" ");
            System.out.println(ans[n-1]);            
        }
    }
    public static boolean backtrack(int[] ans,int sofar,Set<Integer> visited,int n,int sum){
        if(sofar==n){
            if(digitsum(ans,n)==sum)
                return true;
            else return false;
        }
        for(int i=1;i<=n;i++){
            if(!visited.contains(i)){
                ans[sofar] = i;
                visited.add(i);
                if(backtrack(ans,sofar+1,visited,n,sum))
                    return true;
                visited.remove(i);
            }
        }
        return false;
    }
    public static int digitsum(int[] ans,int n){
        int[] nums = Arrays.copyOf(ans,n);
        for(int i=0;i<n-1;i++){
            for(int j=0;j+i<n-1;j++)
                nums[j]+=nums[j+1];
        }
        return nums[0];
    }    
}