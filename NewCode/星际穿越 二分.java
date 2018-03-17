import java.util.*;
public class Main {
    static long max = 1000000000;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);        
        while(input.hasNext()){
            long h = input.nextLong();
            long x = binarySearchUB(0,Math.min(h,max),h);
            System.out.println(x);
        }
    }
    public static long binarySearchUB(long p,long q,long target){
        while(p<q-1){
            long mid = p+(q-p)/2;
            long fm = mid*(mid+1);
            if(fm>target)
                q = mid-1;
            else
                p = mid;
        }
        long qp = q*(q+1),pp=p*(p+1);
        return qp>=0&&qp<=target?q:pp>=0&&pp<=target?p:0;
    }     
}