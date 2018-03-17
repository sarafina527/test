import java.util.*;

public class Main{
	public static class Bind{
		public int index;
		public int value;
		Bind(int i,int v){
			index = i;
			value = v;
		}
	}
	public int[] printOrder(int[] input){
		int[] ans = new int[input.length];
		if(input.length==0) return ans;
		Map<Integer,Integer> toindex = new HashMap<Integer,Integer>();
        LinkedList<Integer> q = new LinkedList<Integer>();
		for(int i=0;i<input.length;i++){
			toindex.put(input[i],i);
            q.add(input[i]);
		}
		while(q.size()>0){
			int head = q.poll();
			int max = head;
			int maxi = -1;
			int i=0;
			for(int num:q){
				if(num>max){
					max = num;
					maxi = i;
				}
				i++;
					
			}
            i=0;
			if(max!=head){
				ans[i++]=toindex.get(head);
				q.offer(head);
				q.remove(i);
			}

		}
        return ans;


	}
}