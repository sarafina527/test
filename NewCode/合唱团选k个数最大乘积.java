import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++) a[i] = input.nextInt();
            int k = input.nextInt(),d=input.nextInt();
            long[][] max = new long[n][k+1];
            long[][] min = new long[n][k+1];
            max[0][1] = (long)a[0];min[0][1] = (long)a[0];
            for(int i=0;i<n;i++){
                max[i][0] = 1L;min[i][0] = 1L;
            }
            for(int i=1;i<n;i++){
                for(int j=1;j<=k;j++){                    
                    if(a[i]==0){
                        max[i][k] = 0;
                    }else{
                        long premax = max[i-1][j-1],premin=min[i-1][j-1];
                        for(int id=i-2;id>=0&&i-id<=d;id--){
                            premax = Math.max(premax,max[id][j-1]);
                            premin = Math.min(premin,min[id][j-1]);
                        }
                        if(a[i]<0){
                            max[i][j] = a[i]*premin;
                            min[i][j] = a[i]*premax;
                        }else{
                            max[i][j] = a[i]*premax;
                            min[i][j] = a[i]*premin;
                        }
                    } 
                }
            }
            //System.out.println(Arrays.deepToString(max));
            long ans = Long.MIN_VALUE;
            for(int i=0;i<n;i++){
                if(ans<max[i][k]) ans=max[i][k];
            }
            System.out.println(ans);            
        }
    }
}
