import java.util.*;
public class Main {  
   
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int m = input.nextInt();
            TreeSet<Integer> set = new TreeSet<Integer>();
            for(int i=0;i<n;i++)
                set.add(input.nextInt());
            for(int i=0;i<m;i++)
                set.add(input.nextInt());
            Iterator<Integer> iter = set.iterator();
            boolean first = true;
            while(iter.hasNext()){
                int cur = iter.next();
                if(first){
                    System.out.print(cur);
                    first = false;
                }else
                    System.out.print(" "+cur);
            }
            System.out.println("");           
        }      
    }
}