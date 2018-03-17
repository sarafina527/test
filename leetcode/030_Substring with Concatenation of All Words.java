public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new LinkedList<Integer>();
        if(s==null||s.length()==0||words==null||words.length==0) return ans;
        int wl = words[0].length;
        int[] windex = new int[s.length()];
        Map<String,Integer> dict = new HashMap<String,Integer>();
        for(int i=0;i<s.length();i++){
            String tmp = s.substring(i,i+wl);

        }
                
        Map<String,Integer> exist = new HashMap<String,Integer>();
        int m = words.length;
        if(m==0) return ans;
        int n = words[0].length();

        for(int i=0;i<m;i++){
        	if(dict.containsKey(words[i]))
        		dict.put(words[i],dict.get(words[i])+1);
        	else
        		dict.put(words[i],1);
        }

        int i=0,j=0;
        for(;i<=s.length()-n;i++){
        	String tmp = s.substring(i,i+n);
        	if(dict.containsKey(tmp)){
        	    exist.clear();
        		exist.put(tmp,1);
        		for(j=1;j<m&&i+j*n+n<=s.length();j++){
        			int start = i+j*n,end=i+j*n+n;
        			String sub = s.substring(start,end);
        			if(dict.containsKey(sub)&&(!exist.containsKey(sub)||exist.get(sub)<dict.get(sub))){
        				int cnt = exist.containsKey(sub)?exist.get(sub)+1:1;
        				exist.put(sub,cnt);
        			}else
        				break;
        		}
        		if(j==m){
        			ans.add(i);
        		}
        	}        	
        }
        return ans;
    }
}