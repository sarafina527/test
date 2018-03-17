import java.util.*;

public class highestScore{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        //List<Integer> ans = new LinkedList<Integer>();
        while(input.hasNext()){
        	int n = input.nextInt();
			int m = input.nextInt();
			//System.out.println(n+" "+m);
			int[] scores = new int[n+1];
			for(int i=1;i<=n;i++){
				scores[i] = input.nextInt();
			}
			for(int i=0;i<m;i++){
				String instructor = input.next();
				int a = input.nextInt();
				int b = input.nextInt();
				//System.out.println(instructor+" "+a+" "+b);
				if(instructor.equals("Q")){				
					if(a<=b) 
	                    System.out.println(highestS(scores,a,b));
					else
						System.out.println(highestS(scores,b,a));
				}else if(instructor.equals("U")){
					scores[a] = b;
				}
			}
        }
		
	}
	public static int highestS(int[] arr,int p,int q){
		int max = Integer.MIN_VALUE;
		for(int i=p;i<=q;i++){			
			if(arr[i]>max)
				max=arr[i];
		}
		return max;
	}
}