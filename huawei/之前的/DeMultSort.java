import java.util.*;
public class DeMultSort{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Set<Integer> nums = new TreeSet();
		while(input.hasNext()){
			int n = input.nextInt();
			nums.clear();
			for(int i=0;i<n;i++){
				int num = input.nextInt();
				nums.add(num);
			}
			for(Integer num:nums){
				System.out.println(num);
			}
		}
		
	}
}