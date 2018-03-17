import java.util.*;
public class Main {  
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);    
        while(input.hasNext()){
            int n = input.nextInt();            
            int[] x= new int[n];
            for(int i=0;i<n;i++){
                x[i] = input.nextInt();
            }
            Set<Integer> cansum = new TreeSet<Integer>();
            Arrays.sort(x);
            subset(0,x,0,cansum,false);
            int i=0;
            for(int j:cansum){
                if(i!=j)
                    break;
                i++;
            }
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