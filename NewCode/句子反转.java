import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String strs = input.nextLine();
            String[] arr = strs.trim().split(" +");
            for(int i=arr.length-1;i>0;i--)
                System.out.print(arr[i]+" ");
            if(arr.length>0)
                System.out.println(arr[0]);
            else
                System.out.println("");
        }
    }
}