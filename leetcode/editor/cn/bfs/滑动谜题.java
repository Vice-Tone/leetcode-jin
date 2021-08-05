package editor.cn.bfs;

//在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示. 
//
// 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换. 
//
// 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。 
//
// 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。 
//
// 示例： 
//
// 
//输入：board = [[1,2,3],[4,0,5]]
//输出：1
//解释：交换 0 和 5 ，1 步完成
// 
//
// 
//输入：board = [[1,2,3],[5,4,0]]
//输出：-1
//解释：没有办法完成谜板
// 
//
// 
//输入：board = [[4,1,2],[5,0,3]]
//输出：5
//解释：
//最少完成谜板的最少移动次数是 5 ，
//一种移动路径:
//尚未移动: [[4,1,2],[5,0,3]]
//移动 1 次: [[4,1,2],[0,5,3]]
//移动 2 次: [[0,1,2],[4,5,3]]
//移动 3 次: [[1,0,2],[4,5,3]]
//移动 4 次: [[1,2,0],[4,5,3]]
//移动 5 次: [[1,2,3],[4,5,0]]
// 
//
// 
//输入：board = [[3,2,4],[1,5,0]]
//输出：14
// 
//
// 提示： 
//
// 
// board 是一个如上所述的 2 x 3 的数组. 
// board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列. 
// 
// Related Topics 广度优先搜索 
// 👍 125 👎 0


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class 滑动谜题 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int slidingPuzzle(int[][] board) {
            StringBuilder sb = new StringBuilder();
            for (int[] ints : board) {
                for (int anInt : ints) {
                    sb.append(anInt);
                }
            }
            //起始字符串，将二维数组扁平化
            String root = sb.toString();
            //目标
            String target = "123450";
            Queue<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();

            //因为将二维数组扁平化了，所以我们要寻找0的上下左右
            //需要借助下面的映射关系
            //0的上下左右在一维字符串中的索引为adj[i]
            int[][] adj = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

            queue.offer(root);
            visited.add(root);

            int step = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String cur = queue.poll();
                    //到达终止条件
                    if (target.equals(cur)) {
                        return step;
                    }
                    //先找到字符串中0的位置
                    int index = 0;
                    for (; cur.charAt(index) != '0'; index++) ;
                    //所有邻接点入队
                    for (int j : adj[index]) {
                        String s = swap(cur, index, j);
                        if (!visited.contains(s)) {
                            queue.offer(s);
                            visited.add(s);
                        }
                    }
                }
                step++;
            }
            return -1;
        }

        private String swap(String tmp, int index, int j) {
            char[] chars = tmp.toCharArray();
            char tmpC = chars[index];
            chars[index] = chars[j];
            chars[j] = tmpC;
            return new String(chars);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}