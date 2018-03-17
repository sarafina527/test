import java.util.*;
public class Main {  
   
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int csn = input.nextInt();
        while(csn-->0){
            int len = input.nextInt();
            int n = input.nextInt();
            int[] ap = new int[n];
            for(int i=0;i<n;i++){
                ap[i] = input.nextInt();
            }
            int mint = 0,maxt = 0;
            for(int i=0;i<n;i++){
                int cur = Math.min(ap[i],len-ap[i]);
                mint = Math.max(mint,cur);
            }
            for(int i=0;i<n;i++){
                int cur = Math.max(ap[i],len-ap[i]);
                maxt = Math.max(maxt,cur);
            }
            System.out.println(mint+" "+maxt);           
        }      
    }
}