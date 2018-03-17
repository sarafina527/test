import java.util.*;

public class Main{

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			if(n>1000) n=1000;
			LinkedList<Integer> queue = new LinkedList<Integer>();
			for(int i=0;i<n;i++){
				queue.offer(i);
			}
			while(queue.size()>1){
				queue.offer(queue.poll());
				queue.offer(queue.poll());
				queue.poll();
			}
			System.out.println(queue.poll());  
		}        		
	}
}