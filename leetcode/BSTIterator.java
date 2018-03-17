public class BSTIterator {
    private Stack<TreeNode> pi;
    private TreeNode nextSmall;
    public BSTIterator(TreeNode root) {
        if(root!=null){
            pi = new Stack<>();
            while(root!=null&&root.left!=null){
                pi.push(root);
                root = root.left;
            }
            nextSmall = root;//find the most left leaf
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(nextSmall==null) return false;
        else return true;
    }

    /** @return the next smallest number */
    public int next() {
        int ans = nextSmall.val;
        boolean found = false;
        if(nextSmall.right!=null){//has the right subtree,next is the smallest of ritree
            pi.push(nextSmall);
            TreeNode rsub = nextSmall.right;
            while(rsub!=null&&rsub.left!=null){
                pi.push(rsub);
                rsub = rsub.left;
            }
            nextSmall = rsub;
            found = true;
        }else{
            TreeNode cur = nextSmall,father;
            while(!pi.isEmpty()){
                father = pi.pop();//get the father of cur
                if(cur==father.left){//that is it
                    nextSmall = father;
                    found = true;
                    break;
                }
                cur = father;
            }
        }
        if(found==false) nextSmall = null;
        return ans;
    }
    private TreeNode smallest(TreeNode root){
        if(root==null) return null;
        while(root!=null&&root.left!=null){
            pi.push(root);
            root = root.left;
        }
        return root.left;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */