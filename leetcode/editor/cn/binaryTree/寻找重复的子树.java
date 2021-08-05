package editor.cn.binaryTree;

//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。 
//
// 示例 1： 
//
//         1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
// 
//
// 下面是两个重复的子树： 
//
//       2
//     /
//    4
// 
//
// 和 
//
//     4
// 
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。 
// Related Topics 树 
// 👍 213 👎 0

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class 寻找重复的子树 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        HashMap<String, Integer> memo = new HashMap<>();

        LinkedList<TreeNode> res = new LinkedList<>();


        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            traverse(root);
            return res;
        }

        String traverse(TreeNode root) {
            if (root == null) {
                return "#";
            }
            String left = traverse(root.left);
            String right = traverse(root.right);
            String subTree = left+","+right+","+root.val;

            Integer num = memo.getOrDefault(subTree, 0);
            if (num == 1) {
                res.add(root);
            }
            memo.put(subTree, num + 1);
            return subTree;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}