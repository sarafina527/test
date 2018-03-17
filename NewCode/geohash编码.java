import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int p=-90,q=91;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<6&&p<q;i++){
                int mid = 0;
                double fmid = p+(q-p)/2.0;
                if(fmid>0)
                    mid = (int)Math.floor(fmid);
                else
                    mid = (int)Math.ceil(fmid);
                if(n<mid){
                    sb.append('0');
                    q = mid;
                }else{
                    sb.append('1');
                    p = mid;
                }
            }
            System.out.println(sb.toString());
        }
    }
       
}