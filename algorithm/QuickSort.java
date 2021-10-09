
import java.util.Arrays;

/**
 * @author ：jin
 * @description: 快速排序
 * @date ：Created in 2021/3/2 14:17
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49};
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * partition版本
     * @param nums
     * @param low
     * @param high
     */
    public void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivot = partition(nums, low, high);
            quickSort(nums, low, pivot - 1);
            quickSort(nums, pivot + 1, high);
        }
    }

    public int partition(int[] nums, int low, int high) {
        int i, j, index;
        i = low;
        j = high;
        index = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= index) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] <= index) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = index;
        return i;
    }

    /**
     * 另一种写法
     * @param a
     */
    public static void quickSort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int low, int high) {
        if (low > high) {
            return;
        }
        //partition函数开始
        int i, j, index;
        i = low;
        j = high;
        index = a[i];
        while (i < j) {
            while (i < j && a[j] >= index) {
                j--;
            }
            if (i < j) {
                a[i++] = a[j];
            }
            while (i < j && a[i] < index) {
                i++;
            }
            if (i < j) {
                a[j--] = a[i];
            }
        }
        a[i] = index;
        //partition函数结束,return i;
        //对左右两个子表递归排序
        sort(a, low, i - 1);
        sort(a, i + 1, high);
    }

}
