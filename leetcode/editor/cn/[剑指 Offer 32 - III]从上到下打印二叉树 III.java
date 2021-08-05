package editor.cn;

//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 86 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class 从上到下打印二叉III {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            ArrayList<List<Integer>> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean flag = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                LinkedList<Integer> tmp = new LinkedList<>();
                if (flag) {
                    for (int i = 0; i < size; i++) {
                        TreeNode top = queue.poll();
                        tmp.addLast(top.val);
                        if (top.left != null) {
                            queue.offer(top.left);
                        }
                        if (top.right != null) {
                            queue.offer(top.right);
                        }
                    }
                    flag = false;
                } else {
                    for (int i = 0; i < size; i++) {
                        TreeNode top = queue.poll();
                        tmp.addFirst(top.val);
                        if (top.left != null) {
                            queue.offer(top.left);
                        }
                        if (top.right != null) {
                            queue.offer(top.right);
                        }

                    }
                    flag = true;
                }

                res.add(tmp);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}