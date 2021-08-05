package editor.cn.bfs;

//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// 👍 248 👎 0

import java.util.LinkedList;
import java.util.Queue;

class 机器人的运动范围 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int movingCount(int m, int n, int k) {
            if (k == 0) {
                return 1;
            }
            int res = 1;
            //定义方向数组
            //因为坐标和大小有限制，所有只需向下和向右搜索
            int[][] map = {{0, 1}, {1, 0}};
            boolean[][] visited = new boolean[m][n];
            Queue<int[]> queue = new LinkedList<>();

            queue.offer(new int[]{0, 0});
            visited[0][0] = true;

            while (!queue.isEmpty()) {
                int[] nums = queue.poll();
                int x = nums[0];
                int y = nums[1];
                for (int i = 0; i < 2; i++) {
                    int tx = x + map[i][0];
                    int ty = y + map[i][1];
                    if (tx < 0 || tx >= m || ty < 0 || ty >= n ||
                            visited[tx][ty] || (get(tx) + get(ty)) > k) {
                        continue;
                    }
                    queue.offer(new int[]{tx, ty});
                    visited[tx][ty] = true;
                    res++;
                }
            }
            return res;
        }

        //计算各位数字之和
        private int get(int x) {
            int sum = 0;
            while (x != 0) {
                sum += x % 10;
                x /= 10;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}