public class Solution {
	Map<String,Boolean> tbl = new HashMap<String,Boolean>();
    public boolean wordBreak(String s, List<String> wordDict) {
    	Collections.sort(wordDict);
        //System.out.println(wordDict);
    	return recurWb(s,wordDict);        
    }
    public boolean recurWb(String s,List<String> wordDict){
        //System.out.println(s);
    	if(tbl.containsKey(s)) return tbl.get(s);
    	int found = Collections.binarySearch(wordDict,s);
    	if(found>=0) return true;
    	int lastless = -found-2;
        //System.out.println(lastless);
    	while(lastless>=0){            
    		String headsub = wordDict.get(lastless);
            if(headsub.charAt(0)!=s.charAt(0)) break;
    		if(headContain(s,headsub)){
                //System.out.println(headsub);
    			if(recurWb(s.substring(headsub.length()),wordDict)){
    				tbl.put(s,true);
    				return true;
    			}    				
    		}            
            lastless--;            
    	}
    	tbl.put(s,false);
    	return false;
    }
    public boolean headContain(String s,String sub){
    	if(s.length()<sub.length()) return false;
    	boolean ans = true;
    	for(int i=0;i<sub.length();i++){
    		if(s.charAt(i)!=sub.charAt(i)){
    			ans = false;
    			break;
    		}
    	}
    	return ans;
    }
}