package editor.cn;

//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/ 
// Related Topics 树 设计 
// 👍 132 👎 0

import java.util.LinkedList;

class 序列化二叉树 {
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

    public class Codec {
        String NULL_TREE = "#";
        String SEP = ",";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serializeTree(root, sb);
            return sb.toString();
        }

        private void serializeTree(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULL_TREE).append(SEP);
                return;
            }
            sb.append(root.val).append(SEP);
            serializeTree(root.left, sb);
            serializeTree(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<Object> list = new LinkedList<>();
            for (String s : data.split(SEP)) {
                list.addLast(s);
            }
            return deserializeTree(list);
        }

        private TreeNode deserializeTree(LinkedList<Object> list) {
            if (list.isEmpty()) {
                return null;
            }
            String first = (String) list.removeFirst();
            if (NULL_TREE.equals(first)) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(first));
            root.left = deserializeTree(list);
            root.right = deserializeTree(list);
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}