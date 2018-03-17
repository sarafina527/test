import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);        
        while(input.hasNext()){
            int n = input.nextInt();
            String[] nums = new String[n];
            for(int i=0;i<n;i++){
                nums[i] = input.next();
            }
            Arrays.sort(nums,new Comparator<String>(){
                public int compare(String s1,String s2){
                    String sc1 = s1+s2;
                    String sc2 = s2+s1;
                    return sc1.compareTo(sc2);
                }
            });
            for(int i=n-1;i>0;i--)
                System.out.print(nums[i]);
            if(n>0) 
                System.out.println(nums[0]);
        }
    }       
}