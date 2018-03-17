import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int rsq = input.nextInt();
            double r = (Math.sqrt(rsq));
            long cnt = 0;
            for(int x=0;x<r;x++){
                double y = Math.sqrt(rsq-x*x);
                if((int)y==y)
                    cnt++;
            }
            System.out.println(cnt*4);
        }
    }
}