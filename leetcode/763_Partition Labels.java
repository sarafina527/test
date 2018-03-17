class Solution {
    //可抽象为区间合并
    public List<Integer> partitionLabels(String S) {
        int[] lin = new int[26];
        Arrays.fill(lin,-1);
        int n = S.length();
        for(int i=n-1;i>=0;i--){
            int c = S.charAt(i)-'a';
            if(lin[c]==-1)
                lin[c] = i;
        }
        int il = -1,ir = -1;
        LinkedList<Integer> ans = new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            int c = S.charAt(i)-'a';
            if(i>ir){
                if(ir>=0)
                    ans.add(ir-il+1);
                il = i;
                ir = lin[c];
            }else{
                if(lin[c]>ir)
                    ir = lin[c];
            }

        }
        if(il<n&&il>=0) ans.add(ir-il+1);
        return ans;
    }
}
