import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dif1 = input.nextInt();
        int dif2 = input.nextInt();
        int sum1 = input.nextInt();
        int sum2 = input.nextInt();
        int A = (dif1+sum1)/2;
        int B = A-dif1;
        int C = B-dif2;
        if(B+C==sum2)
            System.out.println(A+" "+B+" "+C);
        else
            System.out.println("No");
    }       
}