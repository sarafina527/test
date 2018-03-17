import java.util.*;

public class BinarySearch {
    public int getPos(int[] A, int n, int val) {
        int p=0,q=n-1;
        while(q-p>1){
            int mid = p+(q-p)/2;
            //System.out.println(mid+" "+A[mid]);
            if(A[mid]<val)
                p=mid+1;
            else if(A[mid]>val)
                q=mid-1;
            else
                q=mid;
        }
        return A[p]==val?p:A[q]==val?q:-1;
    }
}