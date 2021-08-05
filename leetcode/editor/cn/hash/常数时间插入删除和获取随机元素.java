package editor.cn.hash;

//设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。 
//
// 
// insert(val)：当元素 val 不存在时，向集合中插入该项。 
// remove(val)：元素 val 存在时，从集合中移除该项。 
// getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。 
// 
//
// 示例 : 
//
// 
//// 初始化一个空的集合。
//RandomizedSet randomSet = new RandomizedSet();
//
//// 向集合中插入 1 。返回 true 表示 1 被成功地插入。
//randomSet.insert(1);
//
//// 返回 false ，表示集合中不存在 2 。
//randomSet.remove(2);
//
//// 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
//randomSet.insert(2);
//
//// getRandom 应随机返回 1 或 2 。
//randomSet.getRandom();
//
//// 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
//randomSet.remove(1);
//
//// 2 已在集合中，所以返回 false 。
//randomSet.insert(2);
//
//// 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
//randomSet.getRandom();
// 
// Related Topics 设计 数组 哈希表 
// 👍 262 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class 常数时间插入删除和获取随机元素 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedSet {
        public List<Integer> nums;
        public HashMap<Integer, Integer> valToIndex;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            nums = new ArrayList<>();
            valToIndex = new HashMap<>(16);
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (valToIndex.containsKey(val)) {
                return false;
            }
            valToIndex.put(val, nums.size());
            nums.add(val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!valToIndex.containsKey(val)) {
                return false;
            }
            int index = valToIndex.get(val);
            valToIndex.put(nums.get(nums.size()-1), index);
            nums.set(index, nums.get(nums.size()-1));
            nums.remove(nums.size()-1);
            valToIndex.remove(val);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            Random random = new Random();
            int index = random.nextInt(nums.size());
            return nums.get(index);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}