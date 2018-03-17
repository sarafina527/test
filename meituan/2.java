import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int s[] = new int[n];
            int max = 0;
            int sum = 0;
            ArrayList<Integer> cands = new ArrayList<Integer>();
            for(int i=0;i<n;i++){
                int k = input.nextInt();
                max = Math.max(max,k);
                sum+=k;
            }
            //Arrays.sort(s);
            if(max<=0.5*sum)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}