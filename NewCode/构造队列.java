import java.util.*;

public class Main{
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while(t-->0){
            int n = input.nextInt();
            if(n==1) System.out.println(1);
            else{
                int[] que = new int[n];
                LinkedList<Integer> indices = new LinkedList<Integer>();
                for(int i=0;i<n;i++) indices.add(i);
                int pos = 1;
                Iterator<Integer> iter = indices.iterator();
                int i = 1;
                while(indices.size()>0&&i<=n){
                    if(!iter.hasNext()) iter = indices.iterator();
                    iter.next();
                    if(!iter.hasNext()) iter = indices.iterator();
                    int index = iter.next();
                    iter.remove();
                    que[index] = i++; 
                }
                for(i=0;i<n-1;i++)
                    System.out.print(que[i]+" ");
                System.out.println(que[n-1]);
            }
        }
    }
}