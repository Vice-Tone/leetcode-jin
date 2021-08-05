package editor.cn;

//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
//  3
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// Related Topics 树 
// 👍 234 👎 0

class 树的子结构 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        private Boolean flag = false;

        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) {
                return flag;
            }
            traverse(A, B);
            return flag;
        }

        private void traverse(TreeNode a, TreeNode b) {
            if (a == null) {
                return;
            }
            if (a.val == b.val && isSubTree(a, b)) {
                flag = true;
                return;
            }
            traverse(a.left, b);
            traverse(a.right, b);
        }

        private boolean isSubTree(TreeNode a, TreeNode b) {
            if (a == null && b != null) {
                return false;
            }
            if (b == null) {
                return true;
            }
            return a.val == b.val && isSubStructure(a.left, b.left) && isSubTree(a.right, b.right);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}