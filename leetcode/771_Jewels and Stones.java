class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jw = new HashSet<Character>();
        for(int i=0;i<J.length();i++){
            char c = J.charAt(i);
            jw.add(c);
        }
        int ans = 0;
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            if(jw.contains(c))
                ans++;
        }
        return ans;
    }
}
