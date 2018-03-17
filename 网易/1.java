import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        while(cases-->0){
            int n = input.nextInt();
            int[] a= new int[n];
            for(int i=0;i<n;i++)
                a[i] = input.nextInt();
            if(cases>0)
                System.out.println(helper(a));
            else
                System.out.println(helper(a));
        }
    }
    String helper(int arr[]) {
        int c4=0;
        int c=0;
        int c2=0;
        for(int e:arr) {
            if(e%4==0) c4++;
            else if(e%2==0) c2++;
            else c++;
        }
        
        if(c2==arr.size()) return "Yes";
        
        if(c4==0) return "No";
        
        if(c4>=c-1) return "Yes";
        else return "No";
    }
       
}