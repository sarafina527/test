public class Solution {
    public int findLUSlength(String a, String b) {
        if(a==null||a.equals(b)) return -1;
        else return Math.max(a.length(),b.length());
    }
}