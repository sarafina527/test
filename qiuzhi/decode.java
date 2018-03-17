import java.util.*;
public class decode{
	static String tbl = "FGRSTLMNOPQWXYZUAGHIJKBCDEpijkfghlmnoeqrwxyzabcdstuv";
	public static void main(String[] args) {		
		//char[] tbl = new char[52]{'F','G','R','S','T','L','M','N','O','P','Q','W','X','Y','Z','U','A','G',''}
		//System.out.println(tbl.length());
		Scanner input = new Scanner(System.in);
		String encode = input.next();
		if(encode.matches("\\#+")){
			System.out.println("");
			return;
		} 
		String[] words = encode.split("\\#+");
		//System.out.println(Arrays.toString(words));
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		for(int i=0;i<words.length;i++){
			if(words[i]==null||words[i].length()==0)
				continue;
			int index = seg2int(words[i]);
			if(index<0||index>=tbl.length()){
				flag = false;
				break;
			}
			sb.append(tbl.charAt(index));			
		}
		if(flag)
			System.out.println(sb.toString());
		else
			System.out.println("ERROR");
	}
	public static int seg2int(String s){
		if(s==null||s.length()==0) return -1;
		int ans = 0;
		int n = s.length();
		for(int i=0;i<n;i++){
			if(s.charAt(i)=='.')
				ans |= (1<<(n-i-1));
			else if(s.charAt(i)!='-')
				return -1;
			if(ans>=tbl.length()) return -1;
		}
		return ans;
	}
}