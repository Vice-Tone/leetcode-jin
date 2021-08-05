package editor.cn.binaryTree;

//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。 
//
// 
//
// 示例： 
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 树 动态规划 
// 👍 790 👎 0

import java.util.LinkedList;
import java.util.List;

class 不同的二叉搜索树II {
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
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) {
                return new LinkedList<TreeNode>();
            }
            return generateTrees(1, n);
        }

        public List<TreeNode> generateTrees(int start, int end) {
            LinkedList<TreeNode> allTrees = new LinkedList<TreeNode>();
            if (start > end) {
                allTrees.add(null);
                return allTrees;
            }
            for (int i = start; i <= end; i++) {
                List<TreeNode> lefts = generateTrees(start, i - 1);
                List<TreeNode> rights = generateTrees(i + 1, end);

                for (TreeNode left : lefts) {
                    for (TreeNode right : rights) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        allTrees.add(root);
                    }
                }
            }
            return allTrees;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}