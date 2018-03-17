import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int s[] = new int[n];
            ArrayList<Integer> cands = new ArrayList<Integer>();
            for(int i=0;i<n;i++){
                cands.add(input.nextInt());
            }
            //System.out.println(cands);
            ArrayList<Integer> sofar = new ArrayList<Integer>();
            Set<Integer> visited = new HashSet<Integer>();
            List<List<Integer> > ans = new LinkedList<List<Integer>>();
            permute(sofar,cands,visited,ans);
            for(List<Integer> p:ans){
                System.out.println(p);
                if(valid(p)){
                    System.out.println("Yes");
                    break;
                }
            }
            System.out.println("No");
        }
    }
    static boolean valid(List<Integer> p){
        boolean flag = false;
        int sofar;
        Iterator<Integer> it = p.iterator();
        sofar = it.next();
        while(it.hasNext()){
            int cur = it.next();
            if(sofar<cur)
                return false;
            if(sofar==cur)
                flag = true;
        }
        return flag;
    }
    static void  permute(ArrayList<Integer> sofar,ArrayList<Integer> cands,Set<Integer> visited,List<List<Integer> >ans){
        if(sofar.size()==cands.size()){
            ArrayList<Integer> copy = new ArrayList<Integer>();
            for(int i:sofar)
                copy.add(i);
            ans.add(copy);
            return;
        }
        for(int c:cands){
            if(!visited.contains(c)){
                sofar.add(c);
                visited.add(c);
                permute(sofar,cands,visited,ans);
                visited.remove(c);
                sofar.remove(sofar.size()-1);
            }
        }
    }
       
}