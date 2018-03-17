import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int p[] = new int[n];
            for(int i=0;i<n;i++){
                p[i] = input.nextInt();
            }
            int k = input.nextInt();
            int[] sum = new int[n];
            sum[0] = p[0]%k;
            for(int i=1;i<n;i++){
                sum[i] = (sum[i-1]+p[i])%k;
            }
            int ans = 0;
            for(int i=0;i<n;i++){
                for(int j=i+ans;j<n;j++){
                    int subsum =0;
                    if(i>0)
                        subsum = (sum[j]-sum[i-1]+k)%k;
                    else
                        subsum = sum[j];
                    if(subsum==0&&j-i+1>ans)
                        ans = j-i+1;
                }
            }
            System.out.println(ans);
        }
    }
       
}