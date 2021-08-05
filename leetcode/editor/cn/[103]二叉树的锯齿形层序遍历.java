package editor.cn;

//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 443 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class 二叉树的锯齿形层序遍历 {
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

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> res = new ArrayList<>();

            Queue<TreeNode> queue = new LinkedList<>();

            boolean flag = false;
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                LinkedList<Integer> tmpList = new LinkedList<>();
                if (flag) {
                    for (int i = 0; i < size; i++) {
                        TreeNode tmp = queue.poll();
                        tmpList.addFirst(tmp.val);
                        if (tmp.left != null) {
                            queue.offer(tmp.left);
                        }
                        if (tmp.right != null) {
                            queue.offer(tmp.right);
                        }
                    }
                    flag = false;
                } else {
                    for (int i = 0; i < size; i++) {
                        TreeNode tmp = queue.poll();
                        tmpList.addLast(tmp.val);
                        if (tmp.left != null) {
                            queue.offer(tmp.left);
                        }
                        if (tmp.right != null) {
                            queue.offer(tmp.right);
                        }
                    }
                    flag = true;
                }
                res.add(tmpList);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}