public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new LinkedList<String>();
        Map<String,Integer> hashtable = new HashMap<String,Integer>();
        for(int i=0;i<=s.length()-10;i++){
            String tmp = s.substring(i,i+10);
            if(hashtable.containsKey(tmp)&&hashtable.get(tmp)==1){
                ans.add(tmp);
                hashtable.put(tmp,2);
            }else if(!hashtable.containsKey(tmp))
                hashtable.put(tmp,1);
        }       
        return ans;
    }
    
}