import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            String[] arr = new String[n];
            for(int i=0;i<n;i++){
                arr[i] = input.next();
            }
            boolean lex = true,len = true;
            for(int i=1;i<n;i++){
                if(lex&&arr[i].compareTo(arr[i-1])<0)
                    lex = false;
                if(len&&arr[i].length()<arr[i-1].length())
                    len = false;
                if(!lex&&!len) break;
            }
            if(lex&&len)
                System.out.println("both");
            else if(lex)
                System.out.println("lexicographically");
            else if(len)
                System.out.println("lengths");
            else
                System.out.println("none");
        }
    }
       
}