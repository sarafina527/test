import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int R = input.nextInt();
            int n = input.nextInt();
            if(R==-1&&n==-1) return;
            int[] x = new int[n];
            for(int i=0;i<n;i++)
                x[i] = input.nextInt();
            Arrays.sort(x);
            int ras=x[0],pos=x[0],i=0;
            boolean sw = true;
            int ans = 0;
            while(i<n){
                for(;i<n;i++){//find pos
                    if(x[i]>ras+R){
                        pos = x[i-1];
                        ans++;
                        break;                   
                    }else if(i==n-1){
                        pos = x[i];
                        ans++;break;
                    }
                }
                for(;i<n;i++){//find next uncover
                    if(x[i]>pos+R){
                        ras = x[i];
                        break;
                    }
                }
            }
            System.out.println(ans);
            
        }
    }
       
}