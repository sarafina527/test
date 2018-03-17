import java.util.*;
public class Main {
    static int a[] = new int[100];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int sum = 0;
            for(int i=0;i<n;i++){
                a[i] = input.nextInt();
                sum+=a[i];
            }
            int ans = 0;
            boolean noAns = false;
            if(sum%n==0){
                int avg = sum/n;
                for(int i=0;i<n;i++){
                    int diff = a[i]-avg;
                    if(diff%2!=0){
                        noAns = true;
                        break;
                    }else{
                        a[i] = diff/2;
                        if(a[i]>0) ans+=a[i];
                    }
                }
            }else noAns = true;
            if(!noAns)
                System.out.println(ans);
            else
                System.out.println(-1);
        }
    }
       
}