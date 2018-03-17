public class Solution {
    public String replaceSpace(StringBuffer str) {
    	int spacecnt = 0;
    	for(int i=0;i<str.length();i++){
    		char c = str.charAt(i);
    		if(c==' ')
    			spacecnt++;
    	}
    	int newlen = 2*spacecnt+str.length();
    	StringBuilder sb = new StringBuilder(newlen);
    	int p1=str.length()-1,p2=newlen-1;
    	while(p1>=0&&p2>=0){
    		char cur = str.charAt(p1--);
    		if(cur!=' ')
    			sb.insert(p2--,cur);
    		else{
    			sb.insert(p2--,'0');
    			sb.insert(p2--,'2');
    			sb.insert(p2--,'%');
    		}
    	}
    	return sb.toString();
    }
}