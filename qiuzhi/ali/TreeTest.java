class TreeNode {
	public int data;      
	public TreeNode left;    
	public TreeNode right; 
	public TreeNode parent;
	private int size = 0;

	public TreeNode(int d) {
		data = d;
		size = 1;
	}
	
	public void setLeftChild(TreeNode left) {
		this.left = left;
		if (left != null) {
			left.parent = this;
		}
	}
	
	public void setRightChild(TreeNode right) {
		this.right = right;
		if (right != null) {
			right.parent = this;
		}
	}
	
	public void insertInOrder(int d) {//中序插入
		if (d <= data) {
			if (left == null) {
				setLeftChild(new TreeNode(d));
			} else {
				left.insertInOrder(d);
			}
		} else {
			if (right == null) {
				setRightChild(new TreeNode(d));
			} else {
				right.insertInOrder(d);
			}
		}
		size++;
	}
	
	public int size() {
		return size;
	}
	//是否是二叉查找树
	public boolean isBST() {
		if (left != null) {
			if (data < left.data || !left.isBST()) {
				return false;
			}
		}
		
		if (right != null) {
			if (data >= right.data || !right.isBST()) {
				return false;
			}
		}		
		
		return true;
	}
	
	public int height() {//求树高
		int leftHeight = left != null ? left.height() : 0;
		int rightHeight = right != null ? right.height() : 0;
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
	public TreeNode find(int d) {//二叉查找
		if (d == data) {
			return this;
		} else if (d <= data) {
			return left != null ? left.find(d) : null;
		} else if (d > data) {
			return right != null ? right.find(d) : null;
		}
		return null;
	}
	//有序数组构造二叉查找
	private static TreeNode createMinimalBST(int arr[], int start, int end){//根据有序数组创建平衡BST，递归
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);
		n.setLeftChild(createMinimalBST(arr, start, mid - 1));
		n.setRightChild(createMinimalBST(arr, mid + 1, end));
		return n;
	}
	
	public static TreeNode createMinimalBST(int array[]) {//有序数组创建平衡BST，包装
		return createMinimalBST(array, 0, array.length - 1);
	}
	
	public void print() {
		if(left!=null){
		    left.print();
		}
		System.out.print(data+" ");
		if(right!=null){
		    right.print();
		}
		
	}
} 
/**
 * 在这里给出对类 TreeTest 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class TreeTest
{
   public static void main(String args[]){
       TreeNode root = new TreeNode(6);
       root.insertInOrder(7);
       root.insertInOrder(5);
       root.insertInOrder(4);
       root.insertInOrder(3);
       root.print();
    }

}
