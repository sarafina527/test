import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String word = input.next();
            boolean onetwo = true,three = true;
            int[] cnt = new int[26];
            int n = word.length();
            for(int i=0;i<word.length()&&onetwo;i++){
                char c = word.charAt(i);
                if(!(c>='A'&&c<='Z')){
                    onetwo = false;break;
                } 
                if(i>0&&c==word.charAt(i-1))
                    onetwo = false;
                cnt[c-'A']++;
            }
            if(onetwo){
                for(int i=0;i<n-3&&three;i++){
                    char f = word.charAt(i);
                    if(cnt[f-'A']<2) continue;
                    for(int j=i+1;j<n-2;j++){
                        char s = word.charAt(j);
                        if(cnt[s-'A']<2) continue;
                        if(contains(word.substring(j+1),f,s)){
                            three = false;
                        }
                    }
                }
            }
            if(onetwo&&three)
                System.out.println("Likes");
            else
                System.out.println("Dislikes");
        }
    }
    public static boolean contains(String str,char f,char s){
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)==f){
                for(int j=i+1;j<str.length();j++){
                    if(str.charAt(j)==s)
                        return true;
                }
            }
        }
        return false;
    }
       
}