package editor.cn.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：jin
 * @description:
 * @date ：Created in 2021/8/11 7:26 下午
 */
public class 字节三面算法 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        LinkedList<Integer> track = new LinkedList<>();
        dfs(nums, 10, track);
        System.out.println(res);

    }

    private static List<List<Integer>> res = new ArrayList<>();


    public static void dfs(int[] nums, int x, LinkedList<Integer> track) {
        int sum = 0;
        for (Integer integer : track) {
            sum += integer;
        }
        if (sum == x) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int curSum = 0;
            for (Integer integer : track) {
                curSum += integer;
            }
            if (curSum > x) {
                continue;
            }
            track.add(nums[i]);
            dfs(nums, x, track);
            track.removeLast();
        }
    }


}
