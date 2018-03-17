import java.util.*;

public class Main{

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String str = input.next();

		Map<Character,Boolean> cnt = new HashMap<Character,Boolean>();
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(cnt.containsKey(c)){
				cnt.put(c,!cnt.get(c));
			}else
				cnt.put(c,true);
		}
		int ans = 0;
		for(boolean oe:cnt.values()){
			if(oe)
				ans++;
		}
		if(ans==0) ans=1;
		System.out.println(ans);
		  		
	}
	
}