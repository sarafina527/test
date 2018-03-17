import java.util.*;
public class decode
{
    public static void main(String[] args) {
		String tbl = "FGRSTLMNOPQWXYZUAGHIJKBCDEPijkfghabcdstuv";
		//char[] tbl = new char[52]{'F','G','R','S','T','L','M','N','O','P','Q','W','X','Y','Z','U','A','G',''}
		Scanner input = new Scanner(System.in);
		String encode = input.next();
		String[] words = encode.split("\\#+");
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		for(int i=0;i<words.length;i++){
			int index = seg2int(words[i]);
			if(index<0){
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
		int ans = 0;
		int n = s.length();
		for(int i=0;i<n;i++){
			if(s.charAt(i)=='.')
				ans |= (1<<(n-i-1));
			if(ans>52) return -1;
		}
		return ans;
	}
}
