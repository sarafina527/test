import java.util.*;
public class Main { 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        while(cases-->0){
            int n = input.nextInt();
            int[] overlaps = new int[200];
            for(int i=0;i<n;i++){
                int ss = (input.nextInt()-1)/2;
                int ee = (input.nextInt()-1)/2;
                if(ss>ee){
                    int tmp = ss;
                    ss = ee;ee=tmp;
                }
                for(int j=ss;j<=ee;j++)
                    overlaps[j]++;
            }
            int ans = 0;
            for(int i=0;i<200;i++){
                ans = Math.max(ans,overlaps[i]);
            }
            System.out.println(ans*10);
        }
    } 
}