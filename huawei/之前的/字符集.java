import java.util.*;

public class Main{

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while(input.hasNext()){
			String str = input.next();
			LinkedHashSet<Character> charset = new LinkedHashSet<Character>();
			for(int i=0;i<str.length();i++){
				char c = str.charAt(i);
				if(!charset.contains(c))
					charset.add(c);
			}
			for(Character c:charset){
				System.out.print(c);
			}
			System.out.println("");	
		}       
        		
	}
}