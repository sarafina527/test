public class Solution {	
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d,new Comparator<String>(){
        	public int compare(String s1,String s2){
        		if(s1.length()!=s2.length())
        			return s2.length()-s1.length();
        		else
        			return s1.compareTo(s2);
        	}
        });
        for(int i=0;i<d.size();i++){
        	String ith = d.get(i);
        	if(contains(s,ith))
        		return ith;
        }
        return "";

    }
    public boolean contains(String s,String sub){
    	int i=0,j=0;
    	for(;i<s.length()&&j<sub.length();i++){
    		if(s.charAt(i)==sub.charAt(j)){
    			j++;
    		}
    	}
    	if(j==sub.length())
    		return true;
    	else 
    		return false;
    }
}