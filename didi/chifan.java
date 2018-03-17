import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int m = input.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i] = input.nextInt();
            }
            cusbatch[] cb = new cusbatch[m];            
            for(int i=0;i<m;i++){
                cb[i] = new cusbatch(input.nextInt(),input.nextInt());
            }
            Arrays.sort(cb,new Comparator<cusbatch>(){
                int compare(cusbatch cb1,cusbatch cb2){
                    return cb2.c/cb2.b - cb1.c/cb2.b;
                }
            });
            for(int i=0;i<m;i++){
                
            }
            System.out.println(dp[n][sum]);
        }
    }
    static class cusbatch{
        int b;
        int c;
        cusbatch(int bb,int cc){
            b = bb;
            c = cc;
        }
    }
}