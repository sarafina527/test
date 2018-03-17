import java.util.*;
public class Main {  
   
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int m = input.nextInt();
            int n = input.nextInt();
            int min = Math.min(m,n);
            int[] conbine = new int[min+1];
            int total = m+n;
            conbine[0] = 1;
            for(int i=1;i<=min;i++){
                conbine[i] = (total-i+1)*conbine[i-1]/i;
            }
            System.out.println(conbine[min]);            
        }      
    }
   
}