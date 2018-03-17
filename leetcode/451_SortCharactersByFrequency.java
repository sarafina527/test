public class Solution {
    public String frequencySort(String s) {
    	StringBuilder ans= new StringBuilder();
    	Map<Character,Integer> freq = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
        	char c = s.charAt(i);
        	if(freq.containsKey(c)){
        		freq.put(c,freq.get(c)+1);
        	}else{
        		freq.put(c,1);
        	}
        }
        List<Map.Entry<Character,Integer> > list = new LinkedList<Map.Entry<Character,Integer> >(freq.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Character,Integer> >(){
        	public int compare(Map.Entry<Character,Integer> o1,Map.Entry<Character,Integer> o2){
        		return o2.getValue()-o1.getValue();
        	}
        });
        for(Map.Entry<Character,Integer> e:list){
        	int cnt = e.getValue();
        	for(int i=0;i<cnt;i++){
        		ans.append(e.getKey());
        	}
        }
        return ans.toString();
    }
}