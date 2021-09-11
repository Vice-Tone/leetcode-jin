
/**
 * @author ：jin
 * @description: 二分查找
 * @date ：Created in 2021/6/22 19:08
 */
public class BinarySearch {
    public static void main(String[] args) {
        int i = recursionBinarySearch(new int[]{-1, 0, 3, 5, 9, 12}, 9, 0, 5);
        System.out.println(i);
    }

    //迭代写法
    public static int commonBinarySearch(int[] arr, int key) {

        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        while (low <= high) {
//            正确写法：
//            mid = (low + high ) >>> 1;
//            mid = low + (high - low) / 2;
//            mid = low + ((high - low) >>> 1);
//            错误写法（运算符优先级问题）：
//            mid = low + (high - low) >>> 1;
            mid = low + (high - low) / 2;
            if (key < arr[mid]) {
                high = mid - 1;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //递归写法
    public static int recursionBinarySearch(int[] arr, int key, int low, int high) {
        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }
        int middle = low + (high - low) / 2;
        if (arr[middle] > key) {
            return recursionBinarySearch(arr, key, low, middle - 1);
        } else if (arr[middle] < key) {
            return recursionBinarySearch(arr, key, middle + 1, high);
        } else {
            return middle;
        }
    }
}
