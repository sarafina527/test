import java.util.*;

public class Different {
    public boolean checkDifferent(String iniString) {
        int len = iniString.length();
        if(len>128) return false;
        boolean char_set[] = new boolean[128];
        for(int i=0;i<len;i++){
            int c = iniString.charAt(i);
            if(char_set[c]) return false;
            char_set[c] = true;
        }
        return true;
    }
}