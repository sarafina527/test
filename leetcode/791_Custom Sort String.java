class Solution {
    public String customSortString(String S, String T) {
        int[] cnt = new int[26];
        boolean[] ap = new boolean[26];
        for(int i=0;i<T.length();i++){
            int c = T.charAt(i)-'a';
            cnt[c]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<S.length();i++){
            int c = S.charAt(i)-'a';
            ap[c] = true;
            for(int j=0;j<cnt[c];j++){
                sb.append(S.charAt(i));
            }
        }
        for(int i=0;i<26;i++){
            if(!ap[i]){
                char c = (char)('a'+i);
                for(int j=0;j<cnt[i];j++){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
