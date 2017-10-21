package jiuzhang.java.elementary;
// Binary Tree Leaf Sum
public class BinaryLeafSum {
    
    // fist approach
    private int sum = 0;
    public int leafSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            sum += root.val;
            return sum;
        }
        
        leafSum(root.left);  //the upper level does not do anything, just let lower level accumulate and return the r
        leafSum(root.right); //  result
        return sum;
    }
    
    // second approach，standard recursion
    public int leafSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        
        return leafSum(root.left) + leafSum(root.right);
    }
    

}
