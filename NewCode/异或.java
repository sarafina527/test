import java.util.*;
public class Main {  
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);    
        while(input.hasNext()){
            int n = input.nextInt();            
            int[] x= new int[n];
            
            //System.out.println(cansum);
            System.out.println(i);        
        }
    }
    public static void subset(int i,int[] a,int sum,Set<Integer> cansum,boolean pretaken){
        if(i==a.length){
            if(!cansum.contains(sum))
                cansum.add(sum);
            return;
        }
        if(i==0||a[i]!=a[i-1]||pretaken){
            subset(i+1,a,sum+a[i],cansum,true);
        }
        subset(i+1,a,sum,cansum,false);
    }
}