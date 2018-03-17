import java.util.*;
public class jinzhitrans{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String s = input.next();
			int len = s.length();
			int ans = 0;
			//StringBuilder ans = new StringBuilder();
			for(int i=0;i<len;i++){
				char c = s.charAt(i);
                if(!(c>='0'&&c<='9'||c>='A'&&c<='F')) break;
                int d;
                if(c>='0'&&c<='9') d = (c-'0');
                else d = (c-'A'+10);
                ans= 16*ans+d;
                System.out.println(d);
				//ans.append(d%10);
			}
			
			System.out.println(String.valueOf(ans));
		}
	}
}