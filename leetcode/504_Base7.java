public class Solution {
    public String convertToBase7(int num) {
        int abs = num>=0?num:-num;
        StringBuilder sb = new StringBuilder();
        while(abs>0){
        	sb.append(abs%7);
        	abs/=7;
        }
        String ans = sb.reverse().toString();
        if(num<0) ans = "-"+ans;
        return ans.length()>0?ans:"0";
    }
}