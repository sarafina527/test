import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);        
        while(input.hasNext()){
            int n = input.nextInt();
            int k = input.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++)
                a[i] = input.nextInt();
            ArrayList<Integer> candind = new ArrayList<Integer>();
            ArrayList<Integer> cands = new ArrayList<Integer>();
            boolean exist[] = new boolean[n+1];
            for(int i=0;i<n;i++){
                if(a[i]==0)
                    candind.add(i);
                else
                    exist[a[i]] = true;
            }
            for(int i=1;i<=n;i++){
                if(!exist[i])
                    cands.add(i);
            }
            // int ipcnt = counttincreasePair(a);
            // int leftcnt = k-counttincreasePair(a);
            int ret = 0;
            ArrayList<Integer> sofar = new ArrayList<Integer>();
            Set<Integer> visited = new HashSet<Integer>();
            List<List<Integer> > ans = new LinkedList<List<Integer>>();
            permute(sofar,cands,visited,ans);
            for(List<Integer> p:ans){
                if(leftip(p,candind,a)==k)
                    ret++;
            }
            System.out.println(ret);
        }
    }
    static int counttincreasePair(int[] a){
        int ans = 0;
        for(int i=0;i<a.length;i++){
            if(a[i]==0) continue;
            for(int j=i+1;j<a.length;j++){
                if(a[j]==0) continue;
                if(a[j]>a[i])
                    ans++;
            }
        }
        return ans;
    }
    static int leftip(List<Integer> p,List<Integer> candind,int[] a){
        int ans = 0;
        for(int i=0;i<candind.size();i++){//init
            a[candind.get(i)] = p.get(i);
        }
        ans = counttincreasePair(a);
        // for(int i=0;i<p.size();i++){
        //     int idx = candind.get(i);
        //     int cur = p.get(i);
        //     a[i] = cur;
        //     for(int j=0;j<idx;j++){//pre
        //         if(a[j]<cur) ans++;
        //     }
        //     for(int j=idx+1;j<a.length;j++)//post
        //         if(a[j]>cur) ans++;
        // }
        return ans;
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