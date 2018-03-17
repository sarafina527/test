import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main
{   
    public static int filter(String str,String pattern)
    {
        int s = 0, p = 0, match = 0, starIdx = -1;            
        while (s < str.length()){            
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){// advancing both pointers
                s++;
                p++;
            }else if (p < pattern.length() && pattern.charAt(p) == '*'){// * found, only advancing pattern pointer
                starIdx = p;
                match = s;
                p++;
            }else if (starIdx != -1){// last pattern pointer was *, advancing string pointer
                p = starIdx + 1;
                match++;
                s = match;
            }else return 0;//current pattern pointer is not star, last patter pointer was not *
        }
        
        while (p < pattern.length() && pattern.charAt(p) == '*')//check for remaining characters in pattern
            p++;
        if(p == pattern.length())
            return 1;
        else 
            return 0;        
    }
    
    public static void main(String[] args) {
        String str=null,pattern=null;
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) 
            str = line.trim();
        line = in.nextLine();
        if(line != null && !line.isEmpty()) 
            pattern = line.trim();
        System.out.println(String.valueOf(filter(str,pattern)));
    }
}
