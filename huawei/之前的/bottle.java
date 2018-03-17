import java.util.*;
public class bottle{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int empbocnt = 0,ans=0;
		while(input.hasNext()){
			empbocnt = input.nextInt();
			ans = 0;
			while(empbocnt>=3){
				ans+=empbocnt/3;
				empbocnt = empbocnt/3+empbocnt%3;
			}
			if(empbocnt==2)
				ans++;
			System.out.println(ans);
		}
	}
	
}