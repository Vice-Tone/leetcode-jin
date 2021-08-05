package editor.cn.binaryTree;

//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// 👍 226 👎 0

class 二叉搜索树的后序遍历序列 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return verify(postorder, 0, postorder.length - 1);
        }

        private boolean verify(int[] postorder, int left, int right) {
            if (left >= right) {
                return true;
            }
            int p = left;
            while (postorder[p] < postorder[right]) {
                p++;
            }
            int m = p;
            while (postorder[p] > postorder[right]) {
                p++;
            }
            return p == right && verify(postorder, left, m - 1) && verify(postorder, m, right - 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}