public class Solution {
    public int lengthLongestPath(String input) {
    	int curlen = 0,maxlen = 0,from = 0,found=input.indexOf("\n");
    	if(found==-1){
        	if(input.contains(".")) return input.length();
        	else return 0;
        }  
    	LinkedList<Integer> level = new LinkedList<Integer>();
        LinkedList<String> path = new LinkedList<String>();        
        level.push(0);
        path.push(input.substring(0,found));
        curlen = found;
        
        while(found!=-1){        	
        	from = found+1;
        	found = input.indexOf("\n",from);
        	int curlevel = 0,i = from;
        	for(;input.charAt(i)=='\t'&&i<input.length();i++,curlevel++);
        	while(curlevel<level.peek()){
    			level.pop();
    			curlen-= (path.pop().length()+1);
    		}
    		String validstr = found==-1?input.substring(i):input.substring(i,found);
        	if(curlevel>level.peek()){
        		level.push(curlevel);
        		path.push(validstr);
        		curlen += (1+validstr.length());        		
        	}else if(curlevel==level.peek()){        		
        		curlen = curlen-path.pop().length()+validstr.length();
        		path.push(validstr);
        	}  
        	if(validstr.contains(".")&&curlen>maxlen)
        		maxlen = curlen;      	
        }
        return maxlen;
    }
}

