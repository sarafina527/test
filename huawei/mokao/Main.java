import java.util.*;

public class Main{

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String str = input.next();
		for(int i=1;i<str.length();i++){
			String pre = str.substring(0,str.length()-i);//del
			if(isEven(pre)){
				System.out.println(str.length()-i);
				break;
			}			
		}        		
	}
	public static boolean isEven(String str){
		if(str.length()%2!=0) return false;
		int len = str.length();
		

		String sub = str.substring(0,len/2);
		String sub2 = str.substring(len/2);
		return sub.equals(sub2);
	
	}
}