class Solution {
    public String complexNumberMultiply(String a, String b) {
        int[] an = complexSplit(a);
        int[] bn = complexSplit(b);
        int ansa = an[0]*bn[0]-an[1]*bn[1];
        int ansb = an[1]*bn[0]+an[0]*bn[1];
        return ansa+"+"+ansb+"i";
    }
    public int[] complexSplit(String str){
    	int[] ans = new int[2];
    	int i = str.indexOf('+');
    	ans[0] = Integer.parseInt(str.substring(0,i));
    	ans[1] = Integer.parseInt(str.substring(i+1,str.length()-1));
    	return ans;
    }
}