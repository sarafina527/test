class Solution {
    public int calPoints(String[] ops) {
        LinkedList<Integer> stk = new LinkedList<Integer>();
        int sum = 0;
        for(int i=0;i<ops.length;i++){
        	if(ops[i].equals("+")){
        		if(!stk.isEmpty()){
        			int la = stk.pop();
        			if(!stk.isEmpty()){
        				int la2 = stk.peek();
        				int cur = la+la2;
        				stk.push(la);
        				stk.push(cur);
        				sum+=cur;
        			}
        		}
        	}else if(ops[i].equals("D")){
        		if(!stk.isEmpty()){
        			int last = stk.peek();
        			int cur = 2*last;
        			stk.push(cur);
        			sum+=cur;
        		}
        	}else if(ops[i].equals("C")){
        		if(!stk.isEmpty()){
        			int last = stk.pop();        			
        			sum-=last;
        		}
        	}else{
        		int cur = Integer.parseInt(ops[i]);
        		stk.push(cur);
        		sum+=cur;
        	}
        }
        return sum;
    }
}