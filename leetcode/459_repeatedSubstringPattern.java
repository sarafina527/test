public class Solution {
    public boolean repeatedSubstringPattern(String s) {
    	boolean ans = true;
    	int patternlen = 0;
    	String pattern = "";
        for(int i=1;i<s.length();i++){
        	if(s.charAt(i)==s.charAt(0)){
        		patternlen = i;
        		pattern = s.substring(0,patternlen);
        		//System.out.println(i+" "+pattern);
        		if(s.length()%patternlen!=0)
        			continue;
        		else{
        			for(int j=i;j<s.length();j+=patternlen){
        				String substr = s.substring(j,j+patternlen);
        				//System.out.println(substr);
        				if(!pattern.equals(substr)){
        					ans = false;
        					break;
        				}
        			}
        			if(ans) return true;
        			ans = true;
        		}
        	}
        }
        return false;
    }
}