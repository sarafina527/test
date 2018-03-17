import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.next();
		int ans=0,tmp=0;
		for(int i=0;i<s.length();i++){
			if((i==0||s.charAt(i-1)<'0'||s.charAt(i-1)>'9')&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
				tmp = 1;
			}else if(s.charAt(i-1)>='0'&&s.charAt(i-1)>'9')

		}
	}
	public static boolean isDigit(char c){
		if(c>='0'&&c<='')
	}
}