import java.util.*;

public class Main{
	static Map<String,Integer> tbl = new HashMap<String,Integer>();
	public static void main(String[] args) {
		String[] tb = new String[]{"3","4","5","6","7","8","9","10","J","Q","K","A","2","joker","JOKER"};
		for(int i=0;i<tb.length;i++)
			tbl.put(tb[i],i);
		Scanner input = new Scanner(System.in);
		String twopoker = input.nextLine();
		String[] pokers = twopoker.split("-");
		if(pokers[0].equals("joker JOKER")||pokers[1].equals("joker JOKER"))
			System.out.println("joker JOKER");
		else{
			String[] first = pokers[0].split(" ");
			String[] second = pokers[1].split(" ");
			if(first.length==4&&second.length!=4)
				System.out.println(pokers[0]);
			else if(first.length!=4&&second.length==4)
				System.out.println(pokers[1]);
			else if(compare(first,second)>0)
				System.out.println(pokers[0]);
			else
				System.out.println(pokers[1]);
		}		
	}
	public static int compare(String[] first,String[] second){
		int ans = 0;
		for(int i=0;i<first.length&&i<second.length;i++){
			int f = tbl.get(first[i]),s = tbl.get(second[i]);
			if(f!=s)
				return f-s;
		}
	}
}