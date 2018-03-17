import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String k = input.next();
            int n = input.nextInt();
            int sofar = 0;
            List<Integer> lens = new ArrayList<Integer>();
            for(int i=0;i<k.length();i++){
                char c = k.charAt(i);
                if(c=='X'){
                    lens.add(k.length()-i);
                }else if(c>='0'&&c<='9'){
                    int yushu = c-'0';
                    yushu = computeMode(yushu,n,k.length()-i);
                    sofar = (sofar+yushu)%n;
                }
            }
            int[] ans = new int[1];ans[0]=0;
            backtrack(sofar,0,lens,ans,n);
            System.out.println(ans[0]);            
        }
    }

    public static void backtrack(int sofar,int curxi,List<Integer> lens,int[] ans,int n){
        if(curxi==lens.size()){
            if(sofar==0)
                ans[0]++;
            return;
        }
        for(int i=0;i<=9;i++){
            int curyu = computeMode(i,n,lens.get(curxi));
            backtrack((sofar+curyu)%n,curxi+1,lens,ans,n);
        } 
    }
    public static int computeMode(int d,int n,int len){
        int ans = d;
        for(int i=0;i<len-1;i++){
            ans = ((ans%n)*(10%n))%n;
        }
        return ans;
    } 
}