import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            String[] opts = new String[n];
            for(int i=0;i<n;i++)
                opts[i]=input.next();
            boolean[] ocupied = new boolean[6];
            int[] ans = new int[1];
            dfs(0,opts,ocupied,ans);
            System.out.println(ans[0]);
        }
    }
    public static void dfs(int peri,String[] opts,boolean[] ocupied,int[] ans){
        if(peri==opts.length) ans[0]++;//target
        else{
            for(int i=0;i<opts[peri].length();i++){
                int worki = opts[peri].charAt(i)-'0';
                if(!ocupied[worki]){
                    ocupied[worki] = true;
                    dfs(peri+1,opts,ocupied,ans);
                    ocupied[worki] = false;
                }                
            }
        }
    }
}