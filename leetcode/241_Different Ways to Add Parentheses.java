public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
    	int n = input.length();    	
        List[][] d = new List[n][n];
        List<Integer> ans = diffWaysToComputeRecur(input,0,n-1,d);
        Collections.sort(ans);
        return ans;
    }
    public List<Integer> diffWaysToComputeRecur(String input,int start,int end,List[][] d){
    	if(d[start][end]!=null)
    		return (List<Integer>)d[start][end];
    	List<Integer> opindex = new ArrayList<Integer>();
    	List<Integer> ans = new LinkedList<Integer>();
        for(int i=start;i<=end;i++){
        	char c = input.charAt(i);
        	if(c=='+'||c=='-'||c=='*')
        		opindex.add(i);
        }
        if(opindex.size()==0){//base case
        	ans.add(Integer.parseInt(input.substring(start,end+1)));
        	return ans;
        }
        for(int lcnt = 0;lcnt<opindex.size();lcnt++){
            int curopti = opindex.get(lcnt);
        	char opt = input.charAt(opindex.get(lcnt));            
        	List<Integer> lans = diffWaysToComputeRecur(input,start,curopti-1,d);
        	List<Integer> rans = diffWaysToComputeRecur(input,curopti+1,end,d);
        	for(int left:lans){
        		for(int right:rans){
        			ans.add(comput(left,right,opt));
        		}
        	}
        }
        d[start][end] = ans;
        return ans;

    }
    public int comput(int a,int b,char opt){
    	if(opt=='+')
    		return a+b;
    	else if(opt=='-')
    		return a-b;
    	else
    		return a*b;
    }
}