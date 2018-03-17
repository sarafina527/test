import java.util.*;
public class Main {
    static String[] nums = new String[10];
    static boolean[] digits = new boolean[10];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int c = Integer.parseInt(input.nextLine());
        while(c-->0){
            String str = input.nextLine();
            nums = str.split(" ");
            int n = nums.length;
            int binMax = (1<<n)-1;
            boolean even = (n%2==0);
            int ans = Integer.MAX_VALUE;
            for(int i=0;i<binMax;i++){
                int cnt = countOne(i);
                if(even&&cnt==n-cnt||!even&&2*cnt+1==n){
                    int mindiff = arrange(i,n,cnt);
                    if(ans>mindiff) ans=mindiff;
                }
            }
            System.out.println(ans);
        }
    }
    public static int arrange(int set,int n,int cnt){
        int ans = Integer.MAX_VALUE;
        boolean left[] = new boolean[n];
        boolean right[] = new boolean[n];
        for(int i=0;i<n;i++){
            int mask = 1<<i;
            if((set&mask)!=0) left[i]=true;
            else right[i] = true;
        }
        List<Integer> leftans = new LinkedList<Integer>();
        List<Integer> rightans = new LinkedList<Integer>();
        StringBuilder lsb = new StringBuilder();
        StringBuilder rsb = new StringBuilder();
        backtrack(left,lsb,leftans,n,cnt);
        backtrack(right,rsb,rightans,n,n-cnt);
        //System.out.println(leftans+" "+rightans);
        for(int a:leftans){
            for(int b:rightans){
                int diff = Math.abs(a-b);
                if(diff<ans) ans = diff;
            }
        }
        return ans;
    }
    public static int countOne(int n){
        int ans=0;
        while(n>0){
            ans++;
            n = n&(n-1);
        }
        return ans;
    }
    
    public static void backtrack(boolean[] digits,StringBuilder sofar,List<Integer> ans,int n,int cnt){
        if(sofar.length()==cnt){
            if(cnt==0) ans.add(0);
            else ans.add(Integer.parseInt(sofar.toString()));
        }else{
            for(int i=0;i<n;i++){
                if(digits[i]){
                    if(sofar.length()==0&&nums[i].equals("0")&&cnt>1)
                        continue;
                    digits[i]=false;
                    sofar.append(nums[i]);
                    backtrack(digits,sofar,ans,n,cnt);
                    int len = sofar.length();
                    sofar.delete(len-1,len);
                    digits[i]=true;
                }
            }
        }
    }
}