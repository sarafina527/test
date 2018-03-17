class WordDictionary {
	class TrieNode {
        char c;
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        boolean isLeaf;

        public TrieNode() {}
        public TrieNode(char c){
            this.c = c;
        }
    }
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word==null) return;
        if(word.equals("")) root.isLeaf=true;
        HashMap<Character,TrieNode> childs = root.children;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode cur;
            if(childs.containsKey(c)){
                cur = childs.get(c);
                childs = cur.children;
            }else{
                cur = new TrieNode(c);
                childs.put(c,cur);
                childs = cur.children;                
            }
            if(i==word.length()-1)
                cur.isLeaf = true;
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word==null) return false;
        if(word.equals("")) return root.isLeaf==true;
        HashMap<Character,TrieNode> childs = root.children;
        return backtrack(0,word,childs);        
    }
    public boolean backtrack(int i,String word,HashMap<Character,TrieNode> childs){
    	if(i==word.length()-1){
    		char c = word.charAt(i);
    		if(childs.containsKey(c)){
    			TrieNode t=childs.get(c);
    			if(t!=null&&t.isLeaf==true) return true;
    		}else if(c=='.'){
    			for(Character can:childs.keySet()){
    				if(childs.get(can).isLeaf==true)
    					return true;
    			}
    		}
    		return false;
    	}
    	char c = word.charAt(i);
    	if(c=='.'){
    		for(Character can:childs.keySet()){
    			if(backtrack(i+1,word,childs.get(can).children))
    				return true;
    		}
    	}else if(childs.containsKey(c)){
    		return backtrack(i+1,word,childs.get(c).children);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */