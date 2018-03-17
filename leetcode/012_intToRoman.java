public class Solution {
    public String intToRoman(int num) {
    	StringBuilder ans = new StringBuilder();
        String lookup[][]={
        	{"","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
        	{"","X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
        	{"","C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
        	{"","M", "MM", "MMM"}
        };
        int thd = num/1000;
        int hund = (num-thd*1000)/100;
        int tend = (num-thd*1000-hund*100)/10;
        int d = num%10;
        ans.append(lookup[3][thd]);
        ans.append(lookup[2][hund]);
        ans.append(lookup[1][tend]);
        ans.append(lookup[0][d]);
        return ans.toString();
    }
}