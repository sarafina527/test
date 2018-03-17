public class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        boolean[][] hasJudged = new boolean[n][n];
        for(int p=0;p<n;p++){
        	for(int q = p;q<n;q++){
        		if(!hasJudged[p][q])
        			judge(s,p,q,isPalindrome,hasJudged);
        	}
        }
        ArrayList<LinkedList<Integer>> choices = new ArrayList<LinkedList<Integer>>(n);
        for(int p=0;p<n;p++){
        	LinkedList<Integer> temp = new LinkedList<Integer>();
        	for(int q=n-1;q>=p;q--){
        		if(isPalindrome[p][q])
        			temp.add(q);
        	}
        	choices.add(temp);
        }
        int[] ans = new int[1];
        ans[0] = s.length();
        LinkedList<String> sofar = new LinkedList<String>();
        backtracking(s,choices,0,sofar,ans);
        return ans[0];
    }
    public boolean judge(String s,int p,int q,boolean[][] isPalindrome,boolean[][] hasJudged){
    	if(hasJudged[p][q]) return isPalindrome[p][q];
    	if(p>=q){
    		isPalindrome[p][q] = true;
    		
    	}else{
    		isPalindrome[p][q] = judge(s,p+1,q-1,isPalindrome,hasJudged)&&(s.charAt(p)==s.charAt(q));
    	}
    	hasJudged[p][q] = true;
    	return isPalindrome[p][q];
    }
    public void backtracking(String s,ArrayList<LinkedList<Integer>> choices,int p,LinkedList<String> sofar,int[] ans){
    	if(p==s.length()){
    		if(sofar.size()-1<ans[0]&&sofar.size()-1>=0)
    	    	ans[0] = sofar.size()-1;
    	}else{
    		for(int i=0;i<choices.get(p).size();i++){
    			int q = choices.get(p).get(i);
    			String subp = s.substring(p,q+1);
    			sofar.addLast(subp);
    			if(sofar.size()<=ans[0])//cut 
    			    backtracking(s,choices,q+1,sofar,ans);
    			sofar.removeLast();
    		}
    	}
    }
}

//"apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp"
