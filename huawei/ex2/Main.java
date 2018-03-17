import java.util.*;

public class Main{
    public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        String str = input.next();
        Scanner strin = new Scanner(str).useDelimiter(", ");
        //strin
        ArrayList<Integer> arrl = new ArrayList<Integer>();
        while(strin.hasNext()){
            arrl.add(strin.nextInt());
        }
       	//String[] strs = str.split(", ");
        
        int[] arr = new int[arrl.size()];
        int j=0;
        for(int m:arrl){
            arr[j++] = m;
        }
        int[] ans = printOrder(arr);
        for(int i=0;i<ans.length-1;i++){
            System.out.print(ans[i]+", ");
        }
        System.out.print(ans[ans.length-1]);

	}
	public static class Bind{
		public int index;
		public int value;
		public Bind(int i,int v){
			index = i;
			value = v;
		}
	}
	public static int[] printOrder(int[] input){
		int[] ans = new int[input.length];
		if(input.length==0) return ans;
        LinkedList<Bind> q = new LinkedList<Bind>();
		for(int i=0;i<input.length;i++){
            q.add(new Bind(i,input[i]));
		}
		int i=0;
		while(q.size()>0){
			Bind head = q.poll();
			Bind max = head;
            boolean flag = false;
			for(Bind num:q){
				if(num.value>head.value){
					max = num;
					//maxi=j;
                    flag = true;
					break;
				}
				//j++;
					
			}
            
			if(flag){
				//ans[i++]=max.index;
				q.offer(head);
				//q.remove(maxi);
			}else{
				ans[i++]=max.index;

			}

		}

        return ans;


	}
}

