public class Solution {
    public String multiply(String num1, String num2) {
    	if(num1.length()<num2.length()){
    		String temp = num1;
    		num1 = num2;
    		num2 = temp;
    	}
    	StringBuilder sum = new StringBuilder();
    	for(int i=0;i<num2.length();i++){
    		StringBuilder onesum = multiplyVsOnedigit(num1,num2.charAt(i));
    		for(int j=i;j<num2.length()-1;j++)
    			onesum.append('0');
    		sum = AddString(sum,onesum);
    	}
    	int i;
    	for(i=0;i<sum.length()-1&&sum.charAt(i)=='0';i++);
    	return sum.substring(i);
    }
    public StringBuilder multiplyVsOnedigit(String num,char c){
    	int d = c-'0',cw=0;
    	StringBuilder ans = new StringBuilder();
    	for(int i=num.length()-1;i>=0;i--){
    		int curd = num.charAt(i)-'0';
    		int prod = curd*d+cw;
    		ans.append(prod%10);
    		cw = prod/10;
    	}
    	while(cw!=0){
    		ans.append(cw%10);
    		cw /= 10;
    	}
    	ans.reverse();
    	return ans;
    }
    public StringBuilder AddString(StringBuilder num1,StringBuilder num2){
    	if(num1.length()<num2.length()){
    		StringBuilder temp = num1;
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
    	return ans;
    }
}