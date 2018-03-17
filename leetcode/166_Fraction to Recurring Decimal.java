public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        
        long b = Math.abs((long)denominator),c=Math.abs((long)numerator);
        long intpart = c/b,truea = c%b,a=10*truea;
        int i;
        
        StringBuilder sb = new StringBuilder();
        if((numerator<0&&denominator>0)||(numerator>0&&denominator<0))
            sb.append('-');
        sb.append(intpart);
        if(truea==0) return sb.toString();
        sb.append('.');
        i=sb.length();
        Map<Long,Integer> reminders = new HashMap<Long,Integer>();
        reminders.put(truea,i);
        
        while(a!=0){
            sb.append(a/b);i++;
        	long r = a%b;
            //System.out.println(r);
        	if(reminders.containsKey(r))
        	{
        		sb.insert(reminders.get(r),"(");
        		sb.append(')');
        		break;
        	}
        	else
        		reminders.put(r,i);
        	
        	a = r*10;
        }
        return sb.toString();
    }
}