import java.util.ArrayList;
import java.util.*;

class MagicIndex {
    public boolean findMagicIndex(int[] A, int n) {
        return findMagicIndex(A,0,n-1);
    }
    public boolean findMagicIndex(int[] A,int p,int q){
        if(p>q||p<0||q>=A.length) return false;
        int mid = p+(q-p)/2;
        if(A[mid]==mid) return true;
        return findMagicIndex(A,p,Math.min(mid-1,A[mid]))||findMagicIndex(A,Math.max(mid+1,A[mid]),q);
    }
}
public class Solution {
    public static void main(String[] args) {
        // Scanner input = new Scanner(System.in);
        // KthNumber sl = new KthNumber();
        // while(input.hasNext()){
        //     int i = input.nextInt();

        //     int ans = sl.findKth(i);
        //     System.out.println(ans);
        // }
        
    }
}