import java.util.*;
public class Main { 
    
    public int minShot(int n,int p,int q,int[] health){
        Arrays.sort(health);
        int ans = 0;
        while(health[n-1]>=0){
            health[n-1]-=p;
            for(int i=0;i<n-1;i++){
                if(health[i]>0) health[i]-=q;
            }
            int j=n-1,cur=health[n-1];
            for(;j>0&&cur<health[j-1];j--){
                health[j] = health[j-1];
            }
            health[j] = cur;
            ans++;
        }
        return ans;        
    }   
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int p = input.nextInt();
            int q = input.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i] = input.nextInt();
            }
            System.out.println(minShot(n,p,q,a));
        }
    }
       
}