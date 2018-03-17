import java.util.*;

public class Main{

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		boolean[] bitset = new boolean[n+1];
		for(int i=0;i<=n;i++){
			bitset[i] = true;
		}
		int ans = 1;
		for(int i=2;i<=n;i++){
			if(bitset[i]==true){
				ans=((int)(ans*2))%1000000007;
				bitset[i] = false;
				for(int j=i*2;j<=n;j+=i){
					bitset[j] = false;
				}
				
			}
			
		}
		System.out.println(ans);
		  		
	}
	
}