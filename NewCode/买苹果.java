import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int ans = Integer.MAX_VALUE;
            for(int i=0;i<=n/8;i++){
                for(int j=0;j<=n/6;j++){
                    if(i*8+j*6==n){
                        if(i+j<ans) ans=i+j;
                    }
                }
            }
            if(ans==Integer.MAX_VALUE) ans=-1;
            System.out.println(ans);
        }
    }       
}