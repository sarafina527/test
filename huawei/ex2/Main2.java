import java.util.*;

public class Main2{
	public static class Bind{
		public int index;
		public int value;
		public Bind(int i,int v){
			index = i;
			value = v;
		}
	}
	public int[] printOrder(int[] input){
		int[] ans = new int[input.length];
		if(input.length==0) return ans;
		//Map<Integer,Integer> toindex = new HashMap<Integer,Integer>();
        LinkedList<Bind> q = new LinkedList<Bind>();
		for(int i=0;i<input.length;i++){
			//toindex.put(input[i],i);
            q.add(new Bind(i,input[i]));
		}
		while(q.size()>0){
			Bind head = q.poll();
			Bind max = head;
			int maxi=0;
            int j=0;
			for(Bind num:q){
				if(num.value>max.value){
					max = num;
					maxi=j;
				}
				j++;
					
			}
            int i=0;
			if(max!=head){
				ans[i++]=max.index;
				q.offer(head);
				//q.remove(maxi);
			}

		}
        return ans;


	}
}