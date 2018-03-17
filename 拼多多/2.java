import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        String[] names = new String[n];
        Map<String,Set<String> > children = new HashMap<String,Set<String>>();
        int root = 0;
        for(int i=0;i<n;i++){
            names[i] = input.next();
            int p = input.nextInt();
            if(p==-1) root = i;
            else{
                if(!children.containsKey(names[p])||children.get(names[p])==null)
                    children.put(names[p],new TreeSet<String>());
                children.get(names[p]).add(names[i]);
            } 
        }
        preorder("",names[root],children);
    }
    public static void preorder(String prefix,String root,Map<String,Set<String> > children){
        System.out.println(root);
        int n = children.get(root).size();
        List<String> chs = new ArrayList<String>();
        for(String c:children.get(root)){
            chs.add(c);
            
        }
        for(int i=0;i<chs.size()-1;i++){
            String c = chs.get(i);
            System.out.print(prefix+"|-- ");
            if(children.get(c)==null||children.get(c).size()==0){
                System.out.println(c);
            }else{
                preorder(prefix+"|   ",c,children);
            }
        }
        String c = chs.get(chs.size()-1);
        System.out.print(prefix+"`-- ");
        if(children.get(c)==null||children.get(c).size()==0){
            System.out.println(c);
        }else{
            preorder(prefix+"    ",c,children);
        }
    }
       
}