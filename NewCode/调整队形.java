import java.util.*;

public class Main{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String str = input.next();
            char[] arr = str.toCharArray();
            //G first
            int scnt = 0;
            int i=0;
            while(i<arr.length&&arr[i]=='G') i++;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]=='G'){
                    scnt+=j-i;
                    i++;
                }
            }
            //B first
            int gcnt = 0;
            i=0;
            while(i<arr.length&&arr[i]=='B') i++;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]=='B'){
                    gcnt+=j-i;
                    i++;
                }
            }            
            System.out.println(Math.min(scnt,gcnt));
        }
                
    }
    
}