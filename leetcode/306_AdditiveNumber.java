public class Solution {
    private int seqcnt = 0;
    public boolean isAdditiveNumber(String num) {
        return backtracking(num,0,null,null);
    }
    public boolean backtracking(String num,int sofari,String pre1,String pre2){
        seqcnt++;
        if(sofari==num.length()){
            if(seqcnt>3)
                return true;
            else
                return false;
        }else if(pre1==null){
    		for(int len = 1;len<=num.length()/2;len++){//至少3个
    			String cur = num.substring(sofari,sofari+len);
    			if(cur.charAt(0)=='0'&&cur.length()>1)//前导0
    				continue;
    			if(backtracking(num,sofari+len,cur,null))
    				return true;
    		}
    	}else if(pre2==null){
    		int prelen = pre1.length();
    		for(int len = 1;len<=(num.length()-prelen)/2;len++){
    			String cur = num.substring(sofari,sofari+len);
    			if(cur.charAt(0)=='0'&&cur.length()>1)
    				continue;
    			if(backtracking(num,sofari+len,pre1,cur))
    				return true;
    		}
    	}else{
    		int prelen = pre2.length()>pre1.length()?pre2.length():pre1.length();
    		String plusans = AddString(pre1,pre2);
    		if(num.substring(sofari).startsWith(plusans)){
    		    //System.out.println(pre1+" "+pre2+" "+plusans);
    			if(backtracking(num,sofari+plusans.length(),pre2,plusans))
    				return true;
    		}
    	}
    	return false;
    }
    public String AddString(String num1,String num2){
    	if(num1.length()<num2.length()){
    		String temp = num1;
    		num1 = num2;
    		num2 = temp;
    	}
    	StringBuilder sb1 = new StringBuilder(num1);
    	StringBuilder sb2 = new StringBuilder(num2);
    	sb1.reverse();sb2.reverse();
    	StringBuilder ans = new StringBuilder();
    	int cw = 0,i;
    	for(i=0;i<sb2.length();i++){
    		int d1 = sb1.charAt(i)-'0';
    		int d2 = sb2.charAt(i)-'0';
    		int sum = d1+d2+cw;
    		ans.append(sum%10);
    		cw = sum/10;
    	}
    	for(;i<sb1.length();i++){
    		int d1 = sb1.charAt(i)-'0';
    		int sum = d1+cw;
    		ans.append(sum%10);
    		cw = sum/10;
    	}
    	while(cw>0){
    		ans.append(cw%10);
    		cw /= 10;
    	}
    	ans.reverse();
    	return ans.toString();
    }
}