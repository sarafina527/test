import java.util.*;

public class Main{

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int[] tx = new int[n];
            int[] ty = new int[n];
            for(int i=0;i<n;i++)
                tx[i] = input.nextInt();
            for(int i=0;i<n;i++)
                ty[i] = input.nextInt();
            int gx = input.nextInt(),gy = input.nextInt();
            int wt = input.nextInt(),tt = input.nextInt();
            int time = wt*(Math.abs(gx)+Math.abs(gy));
            for(int i=0;i<n;i++){
                int tmptime = wt*(Math.abs(tx[i])+Math.abs(ty[i]))+tt*(Math.abs(gx-tx[i])+Math.abs(gy-ty[i]));
                if(tmptime<time) time = tmptime;
            }
            System.out.println(time);
        }
		  		
	}
	
}