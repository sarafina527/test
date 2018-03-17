public class Trie {
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
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        if(node!=null&&node.isLeaf==true)
            return true;
        else
            return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchNode(prefix);
        if(node!=null)
            return true;
        else
            return false;
    }

    private TrieNode searchNode(String word){
        HashMap<Character,TrieNode> childs = root.children;
        TrieNode t=null;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(childs.containsKey(c)){
                t = childs.get(c);
                childs = t.children;
            }else{
                return null;
            }
        }
        return t;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */