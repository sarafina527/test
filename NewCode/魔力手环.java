import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int k = input.nextInt();

            int[] circle = new int[n];
            for(int i=0;i<n;i++)
                circle[i]=input.nextInt();

            int[] combine = new int[k+1];
            combine[0] = 1;
            for(int i=0;i<=k;i++){
                combine[i] = (k-i+1)*combine[i-1]/i;
            }
            int[] sum = new int[n];
            int tmp = circle[0];
            for(int i=0;i<n-1;i++){
                circle[i]=(circle[i]+circle[i+1])%100;
            }
                circle[n-1] = (circle[n-1]+tmp)%100;
            
            for(int i=0;i<n-1;i++)
                System.out.print(circle[i]+" ");
            System.out.println(circle[n-1]);
        }
    }
}