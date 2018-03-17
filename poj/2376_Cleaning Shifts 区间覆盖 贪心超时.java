import java.util.*;
import java.io.*;
public class Main { 
    static class interval{
        int s;int e;
        public interval(int i,int j){
            s=i;e=j;
        }
    }   
    public static void main(String[] args) {
        InputStreamReader input = new InputStreamReader(System.in);
        int n = getInt(input);
        int t = getInt(input);
        interval[] ins = new interval[n];
        for(int i=0;i<n;i++){
            ins[i] = new interval(getInt(input),getInt(input));
        }
        Arrays.sort(ins,new Comparator<interval>(){
            public int compare(interval i1,interval i2){
                return i1.s-i2.s;
            }
        });
        interval cur = ins[0],cand = ins[0];
        if(cur.s>1) System.out.println(-1);
        else{
            int ans = 1;
            for(int i=1;i<=n;i++){
                if(i<n&&ins[i].s<=cur.e+1){
                    if(ins[i].e>cand.e)
                        cand = ins[i];
                }else{
                    cur = cand;
                    ans++;
                    if(cur.e>=t||i==n) break;
                    i--;
                }
            }
            if(cur.e<t) System.out.println(-1);
            else System.out.println(ans);
        }
    }
    public static int getInt(InputStreamReader reader) {  
        int read;  
        int res = 0;  
        boolean isNegative = false;
        try {  
            while ((read = reader.read()) != -1) {  
                if ((char) read == '-') {  
                    res = 0;  
                    isNegative = true;  
                    break;  
                } else if (isNumber((char) read)) {  
                    res = read - '0';  
                    break;  
                }  
            }  
            while ((read = reader.read()) != -1) {  
                char ch = (char) read;  
                if (isNumber(ch)) {  
                    res = res * 10 + (read - '0');  
                } else {  
                    break;  
                }  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        if (isNegative == true) {  
            res = -1 * res;  
        }  
        return res;  
    } 
    public static boolean isBlank(char ch) {  
        if (ch == '\r' || ch == '\n' || ch == ' ') {  
            return true;  
        }  
        return false;  
    }   
    public static boolean isNumber(char ch) {  
        if (ch <= '9' && ch >= '0') {  
            return true;  
        }  
        return false;  
    }  

       
}