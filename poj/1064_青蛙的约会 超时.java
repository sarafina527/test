import java.util.*;
public class Main {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();
        int m = input.nextInt();
        int n = input.nextInt();
        int L = input.nextInt();
        if(m==n) System.out.println("Impossible");
        else{
            int t;
            for(t=1;t<2100000000;t++){
                long curx = (long)x;
                curx = (curx+t%L*(m%L))%L;
                long cury = (long)y;
                cury = (cury+t%L*(n%L))%L;
                if(curx==cury)
                    break;
            }
            System.out.println(t);
        }
    }
}