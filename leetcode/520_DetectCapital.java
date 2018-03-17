public class Solution {
    public boolean detectCapitalUse(String word) {
        int capcnt = 0;
        if(word.length()==0) return true;
        char head = word.charAt(0);
        for(int i=0;i<word.length();i++){
        	char c = word.charAt(i);
        	if(c>='A'&&c<='Z')
        		capcnt++;
        }
        if(capcnt==word.length()||capcnt==0)
        	return true;
        else if(capcnt==1&&(head>='A'&&head<='Z'))
        	return true;
        else
        	return false;

    }
}