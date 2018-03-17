public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        int n = sequence.length;
        if(n==0) return false;
        return VerifyPostOrder(sequence,0,n);
    }
    public boolean VerifyPostOrder(int[] seq,int s,int e){
        if(s==e) return true;
        int root = seq[e-1],i;
        for(i=s;i<e-1;i++){
            if(seq[i]>root)
                break;
        }
        for(;i<e-1;i++){
            if(seq[i]<root)
                return false;
        }
        boolean left = VerifyPostOrder(seq,s,i);
        boolean right = VerifyPostOrder(seq,i,e-1);
        return left&&right;
    }
}