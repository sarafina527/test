import java.util.*;
public class Main {  
    static class pair{
        int i;int j;
        public pair(int ii,int jj){
            i=ii;j=jj;
        }
        public boolean equals(pair p){
            return p.i==i&&p.j==j;
        }
        public int hashCode(){
            return i*31+j;
        }
    }  
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);        
        while(input.hasNext()){
            int ac = input.nextInt();
            int a[] = new int[ac];
            for(int i=0;i<ac;i++){
                a[i] = input.nextInt();
            }
            int bc = input.nextInt();
            int b[] = new int[bc];
            for(int i=0;i<bc;i++){
                b[i] = input.nextInt();
            }
            int[][] dp = new int[ac][bc];
            int[][] tail = new int[ac][bc];
            int ans = 0;
            pair maxpt = new pair(-1,-1);
            Map<pair,pair> pi = new HashMap<pair,pair>();
            for(int i=0;i<ac;i++){
                for(int j=0;j<bc;j++){
                    if(a[i]==b[j]){
                        int cur = 1;
                        pair pre = new pair(-1,-1);
                        for(int k=i-1;k>=0;k--){
                            for(int s=j-1;s>=0;s--){
                                if(a[i]>tail[k][s]&&dp[k][s]+1>cur){
                                    cur = dp[k][s]+1;
                                    pre.i=k;pre.j=s;
                                }
                            }
                        }
                        dp[i][j] = cur;
                        pi.put(new pair(i,j),pre);
                        if(ans<dp[i][j]){
                            ans = dp[i][j];
                            maxpt.i=i;maxpt.j=j;
                        } 
                        tail[i][j] = a[i];
                    }
                }
            }
            System.out.println(ans);
            pair pre = maxpt;
            ArrayList<Integer> list = new ArrayList<Integer>();
            while(pre!=null&&pre.i>=0&&pre.j>=0){
                list.add(a[pre.i]);
                pre = pi.get(pre);
                System.out.println(pre);
            }
            for(int i=list.size()-1;i>0;i--){
                System.out.print(list.get(i));
            }
            if(list.size()>0)
                System.out.println(list.get(0));
        }
    }       
}