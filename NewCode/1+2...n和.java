public class Solution {
    public int Sum_Solution(int n) {
        if(n==1) return 1;
        else return n+Sum_Solution(n-1);
    }
}