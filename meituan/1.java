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
            int d[][] = new int [n][n];
            int ans = 0;
            for(int i=0;i<n;i++){
                d[i][i] = p[i];
                if(d[i][i]%k==0&&ans<1)
                    ans = 1;
                for(int j=i+1;j<n;j++){
                    d[i][j] = d[i][j-1]+p[j];
                    if(d[i][j]%k==0&&j-i+1>ans)
                        ans = j-i+1;
                }
            }

            System.out.println(ans);
        }
    }
       
}