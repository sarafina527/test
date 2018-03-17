import java.util.*;
public class Main {  
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);    
        int n = Integer.parseInt(input.nextLine());
        Map<String,String> cur = new HashMap<String,String>();
        Map<String,Map<String,String> > ss = new HashMap<String,Map<String,String> >();
        for(int i=0;i<n;i++){
            String op = input.nextLine();
            String[] oparr = op.trim().split(' ');
            switch (oparr[0]) {
                case "put":
                    cur.put(oparr[1],oparr[2]);break;
                case "mkss":
                    Map<String,String> snap = new HashMap<String,String>();
                    snap.putAll(cur);
                    ss.put(oparr[1],snap);
                    break;
                case "get":
                    if(oparr.length()==2){
                        if(cur.containsKey(oparr[1])){
                            System.out.println(cur.get(oparr[1]));
                        }else
                            System.out.println("(NULL)");
                    }else{
                        if(ss.containsKey(oparr[2])){
                            System.out.println(ss.get(oparr[2]).get(oparr[1]));
                        }else
                            System.out.println("UNKNOWN_SSID");
                    }
                    break;
                case "del":
                    if(cur.containsKey(oparr[1]))
                        cur.remove(oparr[1]);

                
            }
        }
        
        System.out.println(ans);
    }
    
}