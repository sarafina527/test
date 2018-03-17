import java.util.*;
import java.math.BigInteger;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int fivecnt = 0;
        while(n>0){
            fivecnt+=(n/5);
            n/=5;
        }
        System.out.println(fivecnt);
    }
}
