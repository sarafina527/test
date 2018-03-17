import java.util.*;
public class Main {
    static int m = 1000000007; 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int k = input.nextInt();
            int d[][] = new int[n+1][k+1];
            for(int i=1;i<=k;i++){
            	d[1][i] = 1;
            }
            for(int i=2;i<=n;i++){
            	for(int j=1;j<=k;j++){
            		for(int a=1;a<=k;a++){
            			if(a<=j||a%j!=0)
            				d[i][j]=(d[i][j]+d[i-1][a])%m;
            		}
            	}
            }
            int ans = 0;
            for(int i=1;i<=k;i++){
            	ans=(ans+d[n][i])%m;
            }
            System.out.println(ans);
        }
    }       
}