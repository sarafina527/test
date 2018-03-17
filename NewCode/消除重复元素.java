import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int[] seq = new int[n];
            for(int i=0;i<n;i++)
                seq[i] = input.nextInt();
            Set<Integer> vis = new LinkedHashSet<Integer>();
            //LinkedList<Integer> rev = new LinkedList<Integer>();
            for(int i=n-1;i>=0;i--){
                if(!vis.contains(seq[i])){
                    vis.add(seq[i]);
                }
            }
            int[] ans = new int[vis.size()];
            int i=ans.length-1;
            for(int e:vis){
                ans[i--] = e;
            }
            for(i=0;i<ans.length-1;i++)
                System.out.print(ans[i]+" ");
            System.out.println(ans[i]);
        }
    }
}