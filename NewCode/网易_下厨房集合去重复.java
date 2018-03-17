import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Set<String> set = new HashSet<String>();
        while(input.hasNext()){
            String tmp = input.next();
            if(!set.contains(tmp))
                set.add(tmp);
        }
        System.out.println(set.size());
    }
}