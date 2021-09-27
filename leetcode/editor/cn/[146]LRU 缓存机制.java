package editor.cn;

//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1337 👎 0

import java.util.HashMap;
import java.util.Objects;

class LRU缓存机制 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
//    class LRUCache {
//        //缓存容量
//        int cap;
//        //使用map作为缓存,队头为最近使用的
//        LinkedHashMap<Integer, Integer> cache;
//
//        public LRUCache(int capacity) {
//            this.cap = capacity;
//            this.cache = new LinkedHashMap<>();
//        }
//
//        public int get(int key) {
//            if (!cache.containsKey(key)) {
//                return -1;
//            }
//            makeRecently(key);
//            return cache.get(key);
//        }
//
//
//
//        public void put(int key, int value) {
//            //先判断缓存中是否存在
//            if (cache.containsKey(key)) {
//                cache.put(key, value);
//                makeRecently(key);
//                return;
//            }
//            //不存在，往缓存中添加
//            if (cache.size() >= cap) {
//                //缓存满了，需要淘汰
//                Integer oldest = cache.keySet().iterator().next();
//                cache.remove(oldest);
//            }
//            cache.put(key, value);
//        }
//
//        private void makeRecently(int key) {
//            int value = cache.get(key);
//            cache.remove(key);
//            cache.put(key, value);
//        }
//    }

    //使用Api
//    class LRUCache extends LinkedHashMap<Integer, Integer> {
//
//        private int capacity;
//
//        public LRUCache(int capacity) {
//            super(capacity, 0.75f, true);
//            this.capacity = capacity;
//        }
//
//        public int get(int key) {
//            return super.getOrDefault(key,-1);
//        }
//
//        public void put(int key, int value) {
//            super.put(key, value);
//        }
//
//        @Override
//        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//            return size() > capacity;
//        }
//    }


    // 自己实现LRU

    class LRUCache {

        // 双向链表节点
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;

            public DLinkedNode() {
            }

            public DLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private HashMap<Integer, DLinkedNode> map;
        // private int size;
        private int capacity;
        // 链表头部表示最近使用的
        // 尾部表示最久未使用的
        private DLinkedNode head;
        private DLinkedNode tail;

        // 构造方法
        public LRUCache(int cap) {
            map = new HashMap<>();
            capacity = cap;
            //注意这个地方，伪头结点，伪尾结点
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        //先看存不存在，不存在返回-1，存在的话get后将节点移动到head
        public int get(int key) {
            DLinkedNode node = map.get(key);
            if (Objects.isNull(node)) {
                return -1;
            } else {
                moveToHead(node);
                return node.value;
            }
        }

        //先看存不存在，存在的话就是更新，移动到head
        //不存在的话就put进去，添加到head，并判断是否达到容量限制
        public void put(int key, int value) {
            DLinkedNode node = map.get(key);
            //存在
            if (!Objects.isNull(node)) {
                node.value = value;
                moveToHead(node);
            }
            //不存在
            else {
                DLinkedNode newNode = new DLinkedNode(key, value);
                map.put(key, newNode);
                addToHead(newNode);
                //超出容量限制
                if (map.size() > capacity) {
                    DLinkedNode tail = removeTail();
                    // 删除哈希表中对应的项
                    map.remove(tail.key);
                }
            }
        }

        //删除尾结点
        private DLinkedNode removeTail() {
            DLinkedNode tailPrev = tail.prev;
            tailPrev.prev.next = tail;
            tail.prev = tailPrev.prev;
            return tailPrev;
        }

        //将node移动到head
        //先删除，然后移动
        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        //添加到head
        //双向链表操作四步
        private void addToHead(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        //从双向链表中删除node
        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}