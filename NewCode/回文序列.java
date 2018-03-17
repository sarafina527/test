import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] item = new int[n];
        for(int i=0;i<n;i++){
            item[i] = input.nextInt();
        }
        int p=0,q=n-1;
        int ans = 0;
        while(p<=q){
            if(item[p]==item[q]){
                p++;q--;
            }else if(item[p]<item[q]){
                item[p+1] = item[p]+item[p+1];
                p++;
                ans++;
            }else{
                item[q-1] = item[q-1]+item[q];
                q--;
                ans++;
            }
        }
        System.out.println(ans);
    }
}