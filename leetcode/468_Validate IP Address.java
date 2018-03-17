class Solution {
    public String validIPAddress(String IP) {
        if(IP.indexOf('.')!=-1){
        	String[] segs = IP.split("\\.");
        	if(segs.length!=4||IP.charAt(IP.length()-1)=='.') return "Neither";
        	int[] nums = new int[4];
        	for(int i=0;i<4;i++){
        		try{
        			int tmp = Integer.parseInt(segs[i]);
        			if(tmp<0||tmp>255||!segs[i].equals(Integer.toString(tmp)))
        				return "Neither";        				

        		}catch (Exception e) {
        			return "Neither";
        		}        		
        	}
        	return "IPv4";

        }else if(IP.indexOf(':')!=-1){
        	String[] segs = IP.split(":");
        	if(segs.length!=8||IP.charAt(IP.length()-1)==':') return "Neither";
        	for(String str:segs){
        		if(str.length()>4||str.length()<1) return "Neither";
        		for(int i=0;i<str.length();i++){
        			char c = str.charAt(i);
        			if(!isLegal(c))
        				return "Neither";
        		}
        	}
        	return "IPv6";
        	
        }else
        	return "Neither";

    }
    boolean isLegal(char c){
    	if((c>='0'&&c<='9')||(c>='a'&&c<='f')||(c>='A'&&c<='F'))
    		return true;
    	else
    		return false;
    }
}