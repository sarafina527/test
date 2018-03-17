import java.util.*;
public class Main {  
   
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int m = input.nextInt();
            int n = input.nextInt();
            boolean first = true;
            for(int i=m;i<=n;i++){
                if(isNarcissistic(i)){
                    if(first){
                        System.out.print(i);
                        first = false;
                    }else
                        System.out.print(" "+i);
                }
            }
            if(first)
                System.out.println("no");
            else
                System.out.println("");
            
        }      
    }
    public static boolean isNarcissistic(int i){
        int num = i;
        int c = num%10;
        num/=10;
        int b = num%10;
        num/=10;
        int a = num;
        int res = (int)(Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3));
        return res==i;
    }
}