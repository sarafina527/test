import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int m = input.nextInt();
            Set<String> remem = new HashSet<String>();
            Set<String> dict = new HashSet<String>();            
            for(int i=0;i<n;i++){
                String tmp = input.next();
                if(!remem.contains(tmp))
                    remem.add(tmp);
            }
            for(int i=0;i<m;i++){
                String tmp = input.next();
                if(!dict.contains(tmp))
                    dict.add(tmp);
            }
            long ans = 0;
            for(String tmp:remem){
                if(dict.contains(tmp)){
                    long len = (long)tmp.length();
                    ans+=len*len;
                }
            }
            System.out.println(ans);            
        }
    }    
}