public class Solution {
    public String originalDigits(String s) {
        
        int[] charcnt = new int[26];
        int[] numcnt = new int[10];
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            charcnt[c-'a']++;
        }
        numcnt[0] = charcnt['z'-'a'];
        numcnt[2] = charcnt['w'-'a'];
        numcnt[4] = charcnt['u'-'a'];
        numcnt[6] = charcnt['x'-'a'];
        numcnt[8] = charcnt['g'-'a'];
        numcnt[1] = charcnt['o'-'a']-numcnt[0]-numcnt[2]-numcnt[4];
        numcnt[3] = charcnt['h'-'a']-numcnt[8];
        numcnt[5] = charcnt['f'-'a']-numcnt[4];
        numcnt[7] = charcnt['s'-'a']-numcnt[6];
        numcnt[9] = charcnt['i'-'a']-numcnt[5]-numcnt[6]-numcnt[8];
       
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<10;i++){
            for(int j=0;j<numcnt[i];j++)
                sb.append(i);
        }
        return sb.toString();
    }
}